package lcb;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.lark.pb.basic.v1.DomainSettings;
import com.bytedance.lark.pb.basic.v1.GetInitSettingsResponse;
import com.bytedance.lark.pb.basic.v1.InitSDKRequest;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.ApkUtil;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.DevEnvUtil;
import com.larksuite.framework.utils.j0;
import com.larksuite.framework.utils.z;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.dynamicconfig.v2.interfaces.IGlobalDomainConfigService;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.h;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.vfs.VFSPath;
import com.suite.lark.platform.component.storage.file.LarkFileStorage;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.inject.Inject;
import javax.inject.Singleton;

/* JADX INFO: loaded from: classes35.dex */
@Singleton
public final class d extends c0c.b implements IGlobalDomainConfigService, mcb.b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Object f508631h = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f508632b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Inject
    public j f508633c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<String, DomainSettings.Pair> f508634d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, Map<String, DomainSettings.Pair>> f508635e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, CopyOnWriteArrayList<mcb.a>> f508636f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<mcb.a> f508637g;

    static {
        f508631h = new Object();
    }

    public static com.ss.android.lark.storage.kv.repo.a uf() {
        return kcb.a.b("DYNAMIC_DOMAIN_MMKV_V3_ID");
    }

    @Override // com.ss.android.lark.dynamicconfig.v2.interfaces.IGlobalDomainConfigService
    public final String f0() {
        if (DevEnvUtil.isDebugMode(com.larksuite.framework.utils.b.f285948a) == false) goto L7;
        String r100 = LarkAppContext.inst().buildConfig().getCommitId();
        if (TextUtils.equals(r100, kcb.a.a().getString("GIT_COMMIT_IT", "")) == true) goto L7;
        Log.i("GlobalDomainConfigService", "The GIT_COMMIT_ID of installation package has changed");
        kcb.a.a().putString("GIT_COMMIT_IT", r100);
        rf(true);
    L7:
        OutputStream r101 = null;
        String r102 = null;
        int r103 = 0;
    L9:
        if (r103 >= 5) goto L104;
        VFSPath r104 = LarkFileStorage.b().b(com.ss.android.lark.storage.f.f440957d, new com.ss.android.lark.storage.d(new String[]{"core", "rust_config"}));
        Object r105 = f508631h;
        monitor-enter(r105);
        VFSFile r106 = new VFSFile(r104);     // Catch: Throwable -> L101
        if (r106.exists() == true) goto L15;
        r106.mkdirs();     // Catch: Throwable -> L101
    L15:
        String r107 = kcb.a.a().getString("KEY_LARK_SETTING_VERSION_RECORD", "");     // Catch: Throwable -> L101
        String r108 = ApkUtil.getAppVersionName(com.larksuite.framework.utils.b.f285948a);     // Catch: Throwable -> L101
        VFSFile r109 = new VFSFile(r104.subPath("lark_settings"));     // Catch: Throwable -> L101
        if (r109.exists() == true) goto L18;
    L125:
        r109.delete();     // Catch: Throwable -> L50 Exception -> L52 IOException -> L66
        r109.createNewFile();     // Catch: Throwable -> L50 Exception -> L52 IOException -> L66
        InputStream r110 = com.larksuite.framework.utils.b.f285948a.getAssets().open("lark_settings");     // Catch: Throwable -> L50 Exception -> L52 IOException -> L66
    L127:
        OutputStream r111 = VFSFiles.f444819b.E(r109);     // Catch: Throwable -> L44 Exception -> L46 IOException -> L48
    L121:
        byte[] r112 = new byte[1024];     // Catch: Exception -> L40 IOException -> L42 Throwable -> L88
    L26:
        int r113 = r110.read(r112);     // Catch: Exception -> L40 IOException -> L42 Throwable -> L88
        if (r113 <= (-1)) goto L29;
        r111.write(r112, 0, r113);     // Catch: Exception -> L40 IOException -> L42 Throwable -> L88
        goto L26
    L29:
        r111.flush();     // Catch: Exception -> L40 IOException -> L42 Throwable -> L88
        kcb.a.a().putString("KEY_LARK_SETTING_VERSION_RECORD", r108);     // Catch: Exception -> L40 IOException -> L42 Throwable -> L88
        Log.i("GlobalDomainConfigService", "finish loadConfigFileFromAssets version is " + r108);     // Catch: Exception -> L40 IOException -> L42 Throwable -> L88
        r111.close();     // Catch: Exception -> L32 Throwable -> L101
    L105:
        r110.close();     // Catch: Exception -> L36 Throwable -> L101
    L38:
        monitor-exit(r105);     // Catch: Throwable -> L101
    L39:
        boolean r114 = true;
    L82:
        if (r114 == true) goto L84;
        Log.e("GlobalDomainConfigService", "getSdkConfigDirPath load init config failed.");
        r102 = null;
    L86:
        if (TextUtils.isEmpty(r102) == false) goto L104;
        Log.i("GlobalDomainConfigService", "getSdkConfigDirPath auto retry times " + r103);
        r103 = r103 + 1;
        goto L9
    L84:
        r102 = r104.getAbsolutePath();
        goto L86
    L36:
        e = move-exception;
        Log.w("GlobalDomainConfigService", e);     // Catch: Throwable -> L101
        goto L38
    L32:
        e = move-exception;
        Log.w("GlobalDomainConfigService", e);     // Catch: Throwable -> L101
        goto L105
    L88:
        th = th;
        r101 = r111;
    L90:
        if (r101 != null) goto L123;
    L95:
        if (r110 == null) goto L132;
        r110.close();     // Catch: Exception -> L98 Throwable -> L101
    L133:
        throw th;     // Catch: Throwable -> L101
    L98:
        e = move-exception;
        Log.w("GlobalDomainConfigService", e);     // Catch: Throwable -> L101
        throw th;     // Catch: Throwable -> L101
    L132:
        throw th;     // Catch: Throwable -> L101
    L123:
        r101.close();     // Catch: Exception -> L93 Throwable -> L101
    L93:
        e = move-exception;
        Log.w("GlobalDomainConfigService", e);     // Catch: Throwable -> L101
    L42:
        IOException e100 = e;
    L68:
        Log.w("GlobalDomainConfigService", e100);     // Catch: Throwable -> L88
        if (r111 != null) goto L111;
    L74:
        if (r110 != null) goto L117;
    L80:
        monitor-exit(r105);     // Catch: Throwable -> L101
        r114 = false;
        goto L82
    L117:
        r110.close();     // Catch: Exception -> L77 Throwable -> L101
    L77:
        e = e;
    L79:
        Log.w("GlobalDomainConfigService", e);     // Catch: Throwable -> L101
        goto L80
    L111:
        r111.close();     // Catch: Exception -> L72 Throwable -> L101
    L72:
        e = move-exception;
        Log.w("GlobalDomainConfigService", e);     // Catch: Throwable -> L101
    L40:
        Exception e101 = e;
    L54:
        Log.w("GlobalDomainConfigService", e101);     // Catch: Throwable -> L88
        if (r111 != null) goto L109;
    L60:
        if (r110 == null) goto L80;
        r110.close();     // Catch: Exception -> L63 Throwable -> L101
    L63:
        e = e;
        goto L79
    L109:
        r111.close();     // Catch: Exception -> L58 Throwable -> L101
    L58:
        e = move-exception;
        Log.w("GlobalDomainConfigService", e);     // Catch: Throwable -> L101
    L48:
        e = move-exception;
        e100 = e;
        r111 = null;
    L46:
        e = move-exception;
        e101 = e;
        r111 = null;
    L44:
        th = th;
    L66:
        e = move-exception;
        e100 = e;
        r110 = null;
        r111 = null;
    L52:
        e = move-exception;
        e101 = e;
        r110 = null;
        r111 = null;
    L50:
        th = th;
        r110 = null;
        goto L90
    L18:
        if (TextUtils.equals(r107, r108) == false) goto L125;
        Log.d("GlobalDomainConfigService", "ignore loadConfigFileFromAssets.");     // Catch: Throwable -> L101
        monitor-exit(r105);     // Catch: Throwable -> L101
    L101:
        th = move-exception;
        throw th;
    L104:
        return r102;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12, types: [java.util.Map<java.lang.String, com.bytedance.lark.pb.basic.v1.DomainSettings$Pair>] */
    /* JADX WARN: Type inference failed for: r0v14, types: [java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.util.Map] */
    @Override // com.ss.android.lark.dynamicconfig.v2.interfaces.IGlobalDomainConfigService
    public final void preload() {
        if (uf().b().length <= 0) goto L7;
        Log.i("GlobalDomainConfigService", "get default domain hit cache, will load from cache");
        ?? r100 = new HashMap();
        com.ss.android.lark.storage.kv.repo.a r101 = uf();
        String[] r102 = r101.b();
        int r103 = r102.length;
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L11;
        String r105 = r102[r104];
        r100.put(r105, new DomainSettings.Pair.Builder().alias(DomainSettings.Alias.UNKNOWN).domain("").domains(new ArrayList(r101.getStringSet(r105, new HashSet()))).alias_str(r105).build());
        r104 = r104 + 1;
    L11:
        this.f508634d = r100;
        return;
    L7:
        long r106 = System.currentTimeMillis();
        if (TextUtils.isEmpty(f0()) == false) goto L10;
        Log.e("GlobalDomainConfigService", "getSdkConfigDirPath failed, cannot get rust sdk config file.");
        r100 = 0;
        goto L11
    L10:
        Log.i("GlobalDomainConfigService", "FetchDomainV3 copy file cost " + (System.currentTimeMillis() - r106) + " ms.");
        r100 = tf(gcb.a.a().getEnv2Type(), gcb.a.a().getUserUnit(), gcb.a.a().getTenantBrand());
        goto L11
    }

    @Inject
    public d(j r100) {
        super(r100);
        this.f508632b = new Object();
        this.f508634d = new HashMap();
        this.f508635e = new HashMap();
        this.f508636f = new ConcurrentHashMap();
        this.f508637g = new CopyOnWriteArrayList();
        h.a(this);
        Log.i("GlobalDomainConfigService", "GlobalDomainConfigService constructor called");
    }

    public static void rf(boolean r100) {
        VFSFile r101 = new VFSFile(LarkFileStorage.b().b(com.ss.android.lark.storage.f.f440957d, new com.ss.android.lark.storage.d(new String[]{"core", "rust_config"})).subPath("lark_settings"));
        if (r101.exists() == false) goto L9;
        if (r100 == false) goto L6;
        r101.delete();
    L7:
        Log.i("GlobalDomainConfigService", "clearConfigFile");
        return;
    L6:
        r101.deleteOnExit();
        goto L7
    }

    @Override // com.ss.android.lark.dynamicconfig.v2.interfaces.IGlobalDomainConfigService
    public final void h0(Map<String, List<String>> r100) {
        Iterator r101 = ((CopyOnWriteArrayList) this.f508637g).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((mcb.a) r101.next()).a(r100);
        goto L4
    }

    @Override // com.ss.android.lark.dynamicconfig.v2.interfaces.IGlobalDomainConfigService
    public final Map<String, List<String>> o0(String r100) {
        HashMap r101 = new HashMap();
        LinkedHashSet r102 = new LinkedHashSet();
        if (TextUtils.equals(r100, "absent_user") == true) goto L11;
        if (TextUtils.isEmpty(r100) == true) goto L11;
        Map r103 = (Map) ((HashMap) this.f508635e).get(r100);
        if (CollectionUtils.isEmpty(r103) == true) goto L13;
        r102.addAll(r103.keySet());
    L13:
        String[] r104 = uf().b();
        if (r104 == null) goto L22;
        int r105 = r104.length;
        int r106 = 0;
    L16:
        if (r106 >= r105) goto L22;
        String r107 = r104[r106];
        if (r102.contains(r107) == true) goto L20;
        r102.add(r107);
    L20:
        r106 = r106 + 1;
    L22:
        if (CollectionUtils.isEmpty(r102) == true) goto L24;
    L26:
        Iterator r108 = r102.iterator();
    L28:
        if (r108.hasNext() == false) goto L32;
        String r109 = (String) r108.next();
        List<String> r110 = A(r100, r109);
        if (CollectionUtils.isNotEmpty(r110) == false) goto L28;
        r101.put(r109, r110);
        goto L28
    L32:
        return r101;
    L24:
        if (CollectionUtils.isEmpty(this.f508634d) == true) goto L26;
        r102.addAll(this.f508634d.keySet());
    L11:
        if (CollectionUtils.isEmpty(this.f508634d) == true) goto L13;
        r102.addAll(this.f508634d.keySet());
        goto L13
    }

    public static ArrayList sf(String r100, String r101) {
        ArrayList r102 = null;
        if (TextUtils.equals(r100, "absent_user") == false) goto L5;
    L14:
        int r103 = gcb.a.a().getEnvType().getValue();
        String r104 = gcb.a.a().getUserUnit();
        List r105 = vf(r101, r103, r104, gcb.a.a().getTenantBrand());
        if (CollectionUtils.isNotEmpty(r105) == false) goto L18;
        Log.i("GlobalDomainConfigService", "hitDomainV5 alias: " + r101);
        return new ArrayList(r105);
    L18:
        Set<String> r106 = kcb.a.b("DYNAMIC_DOMAIN_MMKV_V4_ID").getStringSet(r103 + "_" + r104 + "_" + r101, null);
        if (CollectionUtils.isNotEmpty(r106) == false) goto L21;
        ArrayList r107 = new ArrayList(r106);
    L23:
        if (CollectionUtils.isNotEmpty(r107) == false) goto L26;
        String r108 = "getDomainCache(): hit DomainV4. Domain penetration may have occurred! alias: " + r101 + " , process is " + z.c(com.larksuite.framework.utils.b.f285948a);
        Log.e("GlobalDomainConfigService", r108, new IllegalArgumentException(r108));
        return new ArrayList(r107);
    L26:
        Set<String> r109 = uf().getStringSet(r101, null);
        if (CollectionUtils.isNotEmpty(r109) == false) goto L31;
        String r110 = "getDomainCache(): hit DomainV3. Domain penetration may have occurred! alias: " + r101 + " , process is " + z.c(com.larksuite.framework.utils.b.f285948a);
        Log.e("GlobalDomainConfigService", r110, new IllegalArgumentException(r110));
        return new ArrayList(r109);
    L31:
        return new ArrayList();
    L21:
        r107 = null;
        goto L23
    L5:
        if (TextUtils.isEmpty(r100) == true) goto L14;
        Set<String> r111 = kcb.a.b("DYNAMIC_DOMAIN_MMKV_USER_ID").getStringSet(r101 + "_" + r100, null);
        if (CollectionUtils.isNotEmpty(r111) == false) goto L11;
        r102 = new ArrayList(r111);
    L11:
        if (CollectionUtils.isEmpty(r102) == true) goto L31;
        Log.i("GlobalDomainConfigService", "hitUserDomain alias: " + r101);
        return new ArrayList(r102);
    }

    @Override // com.ss.android.lark.dynamicconfig.v2.interfaces.IGlobalDomainConfigService, mcb.b
    public final List<String> A(String r100, String r101) {
        Log.i("GlobalDomainConfigService", "getDomains, uid: " + j0.a(r100) + ", alias: " + r101);
        if (r101 != null) goto L7;
        Log.e("GlobalDomainConfigService", "getDomains alias is null");
        return null;
    L7:
        if (z.e(com.larksuite.framework.utils.b.f285948a) == true) goto L14;
        ArrayList r102 = sf(r100, r101);
        if (CollectionUtils.isNotEmpty(r102) == false) goto L12;
        Log.i("GlobalDomainConfigService", "multi-process domain cache feature on " + r101 + ", get domain from KV cache");
        return r102;
    L12:
        Log.e("GlobalDomainConfigService", "multi-process domain cache feature on " + r101 + ", fetch KV cache failed");
    L14:
        if (TextUtils.equals(r100, "absent_user") == true) goto L24;
        if (TextUtils.isEmpty(r100) == true) goto L24;
        Map r103 = (Map) ((HashMap) this.f508635e).get(r100);
        if (CollectionUtils.isNotEmpty(r103) == false) goto L28;
        DomainSettings.Pair r104 = (DomainSettings.Pair) r103.get(r101);
        if (r104 == null) goto L28;
        List<String> r105 = r104.domains;
    L30:
        if (CollectionUtils.isNotEmpty(r105) == false) goto L33;
        Log.i("GlobalDomainConfigService", "get domain from memory");
        return r105;
    L33:
        Log.w("GlobalDomainConfigService", "get domains config before remote config fetch success, will try load from KV cache, alias is ".concat(r101));
        ArrayList r106 = sf(r100, r101);
        if (CollectionUtils.isNotEmpty(r106) == false) goto L37;
        Log.i("GlobalDomainConfigService", "getdomain from KV cache");
        return r106;
    L37:
        Log.e("GlobalDomainConfigService", "domain cache feature on " + r101 + ", fetch KV cache failed");
        if (CollectionUtils.isEmpty(this.f508634d) == false) goto L41;
        Log.i("GlobalDomainConfigService", "get domains config before default config fetch success , load it");
        preload();
    L41:
        if (CollectionUtils.isNotEmpty(this.f508634d) == false) goto L45;
        DomainSettings.Pair r107 = this.f508634d.get(r101);
        if (r107 == null) goto L45;
        List<String> r108 = r107.domains;
    L47:
        if (CollectionUtils.isNotEmpty(r108) == false) goto L50;
        Log.i("GlobalDomainConfigService", "get domain from default");
        return r108;
    L50:
        Log.e("GlobalDomainConfigService", "get alias pair empty, error key is ".concat(r101));
        return null;
    L45:
        r108 = new ArrayList();
    L28:
        r105 = new ArrayList();
    L24:
        if (CollectionUtils.isNotEmpty(this.f508634d) == false) goto L28;
        DomainSettings.Pair r109 = this.f508634d.get(r101);
        if (r109 == null) goto L28;
        r105 = r109.domains;
        goto L30
    }

    @Override // com.ss.android.lark.dynamicconfig.v2.interfaces.IGlobalDomainConfigService
    public final void Yb(String r100, jcb.a r101) {
        CopyOnWriteArrayList r102 = (CopyOnWriteArrayList) ((ConcurrentHashMap) this.f508636f).get(r100);
        if (CollectionUtils.isEmpty(r102) == false) goto L6;
        Log.i("GlobalDomainConfigService", "remove domain observer failed, domainSettingChangedObservers is empty.");
        return;
    L6:
        Log.i("GlobalDomainConfigService", "remove domain observer, uid: " + j0.a(r100) + ", observer: " + r101.hashCode() + ", result: " + r102.remove(r101));
    }

    @Override // com.ss.android.lark.dynamicconfig.v2.interfaces.IGlobalDomainConfigService, mcb.b
    public final String e0(String r100, String r101) {
        List<String> r102 = A(r100, r101);
        if (CollectionUtils.isNotEmpty(r102) == true) goto L5;
        return null;
    L5:
        return (String) ListProtector.get(r102, 0);
    }

    @Override // com.ss.android.lark.dynamicconfig.v2.interfaces.IGlobalDomainConfigService
    public final void sd(String r100, jcb.a r101) {
        CopyOnWriteArrayList r102 = (CopyOnWriteArrayList) ((ConcurrentHashMap) this.f508636f).get(r100);
        Object r103 = this.f508632b;
        monitor-enter(r103);
        if (r102 != null) goto L6;
        CopyOnWriteArrayList r104 = new CopyOnWriteArrayList();     // Catch: Throwable -> L10
        r104.add(r101);     // Catch: Throwable -> L10
        ((ConcurrentHashMap) this.f508636f).put(r100, r104);     // Catch: Throwable -> L10
    L7:
        monitor-exit(r103);     // Catch: Throwable -> L10
        Log.i("GlobalDomainConfigService", "add domain observer success, uid: " + j0.a(r100) + ", observer: " + r101.hashCode());
        return;
    L6:
        r102.add(r101);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public static Map tf(int r110, String r111, String r112) {
        long r100 = System.currentTimeMillis();
        String r101 = com.ss.android.lark.sdk.a.a();
        HashMap<String, a> r102 = a.f508620j;
        if (gcb.a.a().isPrivateKA() == false) goto L6;
        String r113 = "biz_domain_config";
    L13:
        Object r114 = a.f508621k;
        monitor-enter(r114);
        HashMap<String, a> r115 = a.f508620j;     // Catch: Throwable -> L60
        if (r115.containsKey(r113) == false) goto L20;
        a r116 = r115.get(r113);     // Catch: Throwable -> L60
        monitor-exit(r114);     // Catch: Throwable -> L60
    L23:
        String r117 = r116.g();
        JSONObject r118 = JSON.parseObject(r117);
        ArrayList r103 = new ArrayList();
        if (r118 != null) goto L26;
        Log.e("DefaultDomainConfigHandler", "parseDomainConfig failed with " + r117);
    L37:
        GetInitSettingsResponse r119 = new GetInitSettingsResponse.Builder().domain_settings(new DomainSettings.Builder().pairs(r103).build()).build();
        if (r119 != null) goto L40;
        Log.e("DefaultDomainConfigHandler", "getDefaultDomainConfig get static config failed, of key " + r116.f508622i);
    L40:
        Log.i("GlobalDomainConfigService", "parser domain form lark_settings cost " + (System.currentTimeMillis() - r100) + " ms.");
        if (r119 != null) goto L44;
        Log.e("GlobalDomainConfigService", "GetInitSettingsResponse decode failed.");
        return null;
    L44:
        Log.i("GlobalDomainConfigService", "parser domain form lark_settings total cost " + (System.currentTimeMillis() - r100) + " ms.");
        DomainSettings r120 = r119.domain_settings;     // Catch: Exception -> L49
        if (r120 == null) goto L51;
        List<DomainSettings.Pair> r121 = r120.pairs;     // Catch: Exception -> L49
    L52:
        if (r121 != null) goto L55;
        Log.e("GlobalDomainConfigService", "get default config error , contextId : " + r101 + " , process : " + z.c(com.larksuite.framework.utils.b.f285948a));
        rf(false);
        return null;
    L55:
        Log.i("GlobalDomainConfigService", "get default config success , contextId : " + r101 + " , process : " + z.c(com.larksuite.framework.utils.b.f285948a));
        HashMap r122 = new HashMap();
        Iterator<DomainSettings.Pair> r123 = r121.iterator();
    L57:
        if (r123.hasNext() == false) goto L59;
        DomainSettings.Pair r124 = r123.next();
        r122.put(r124.alias_str, r124);
        goto L57
    L59:
        return r122;
    L51:
        r121 = null;
    L49:
        e = move-exception;
        Log.e("GlobalDomainConfigService", "request failed context id : " + r101, e);
        rf(false);
        goto L51
    L26:
        Iterator<String> r125 = r118.keySet().iterator();
    L28:
        if (r125.hasNext() == false) goto L37;
        String r104 = r125.next();
        ArrayList r105 = new ArrayList();
        JSONArray r106 = r118.getJSONArray(r104);     // Catch: Exception -> L34
        int r107 = r106.size();     // Catch: Exception -> L34
        int r126 = 0;
    L31:
        if (r126 >= r107) goto L36;
        r105.add(r106.getString(r126));     // Catch: Exception -> L34
        r126 = r126 + 1;
    L36:
        r103.add(new DomainSettings.Pair.Builder().alias_str(r104).domains(r105).alias(DomainSettings.Alias.UNKNOWN).domain("").build());
    L34:
        e = move-exception;
        Log.e("DefaultDomainConfigHandler", "parseDomainConfig error, domain key is " + r104, e);
        goto L36
    L20:
        a r108 = new a(r113);     // Catch: Throwable -> L60
        r115.put(r113, r108);     // Catch: Throwable -> L60
        monitor-exit(r114);     // Catch: Throwable -> L60
        r116 = r108;
    L60:
        th = move-exception;
        throw th;
    L6:
        if (r110 != 2) goto L8;
        String r127 = "staging";
    L12:
        r113 = r127 + "_" + r111 + "_" + r112 + "_biz_domain_config";
        goto L13
    L8:
        if (r110 == 3) goto L10;
        r127 = "release";
        goto L12
    L10:
        r127 = "pre_release";
        goto L12
    }

    public static List vf(String r100, int r101, String r102, String r103) {
        Set<String> r104 = kcb.a.b("DYNAMIC_DOMAIN_MMKV_V5_ID").getStringSet(r101 + "_" + r102 + "_" + r103 + "_" + r100, null);
        if (CollectionUtils.isNotEmpty(r104) == true) goto L5;
        return null;
    L5:
        return new ArrayList(r104);
    }

    @Override // com.ss.android.lark.dynamicconfig.v2.interfaces.IGlobalDomainConfigService
    public final List<String> p0(String r110, int r111, String r112, String r113) {
        String r100 = r111 + "_" + r112 + "_" + r113 + "_" + r110;
        List<String> r101 = vf(r110, r111, r112, r113);
        Log.i("GlobalDomainConfigService", "fullEnvUnitBrand lookup, key=" + r100 + ", firstResult=" + r101);
        if (CollectionUtils.isEmpty(r101) == false) goto L19;
        Log.i("GlobalDomainConfigService", "fullEnvUnitBrand lookup miss, trigger fallback, key=" + r100);
        Map r102 = tf(r111, r112, r113);
        if (r102 != null) goto L16;
    L14:
        List<String> r103 = vf(r110, r111, r112, r113);
        Log.i("GlobalDomainConfigService", "fullEnvUnitBrand lookup after fallback, key=" + r100 + ", secondResult=" + r103);
        return r103;
    L16:
        HashMap r104 = (HashMap) r102;     // Catch: Exception -> L12
        Iterator r105 = r104.keySet().iterator();     // Catch: Exception -> L12
    L8:
        if (r105.hasNext() == false) goto L10;
        String r106 = (String) r105.next();     // Catch: Exception -> L12
        uf().putStringSet(r106, new LinkedHashSet(((DomainSettings.Pair) r104.get(r106)).domains));     // Catch: Exception -> L12
        kcb.a.b("DYNAMIC_DOMAIN_MMKV_V4_ID").putStringSet(r111 + "_" + r112 + "_" + r106, new LinkedHashSet(((DomainSettings.Pair) r104.get(r106)).domains));     // Catch: Exception -> L12
        kcb.a.b("DYNAMIC_DOMAIN_MMKV_V5_ID").putStringSet(r111 + "_" + r112 + "_" + r113 + "_" + r106, new LinkedHashSet(((DomainSettings.Pair) r104.get(r106)).domains));     // Catch: Exception -> L12
        goto L8
    L10:
        Log.i("GlobalDomainConfigService", "write lark_settings domain success");     // Catch: Exception -> L12
    L12:
        e = move-exception;
        Log.e("GlobalDomainConfigService", "write lark_settings domain failed", e, true);
        goto L14
    L19:
        return r101;
    }

    @Override // com.ss.android.lark.dynamicconfig.v2.interfaces.IGlobalDomainConfigService
    public final void K0(final String r100, InitSDKRequest.EnvType r101, String r110, String r111, DomainSettings r112) {
        Log.i("GlobalDomainConfigService", "real updateDomainSetting, uid: " + j0.a(r100) + ", envType: " + r101 + ", unit:" + r110 + ", brand:" + r111);
        if (r112 != null) goto L6;
        Log.e("GlobalDomainConfigService", "updateDomainSetting domainSettings is null");
        return;
    L6:
        List<DomainSettings.Pair> r113 = r112.pairs;
        if (r113 != null) goto L10;
        Log.e("GlobalDomainConfigService", "updateDomainSetting pairs is null");
        return;
    L10:
        HashMap r102 = new HashMap();
        final HashMap r103 = new HashMap();
        Iterator<DomainSettings.Pair> r114 = r113.iterator();
    L12:
        if (r114.hasNext() == false) goto L14;
        DomainSettings.Pair r104 = r114.next();
        r102.put(r104.alias_str, r104);
        r103.put(r104.alias_str, r104.domains);
        goto L12
    L14:
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new b(this, r100, r103));
        if (TextUtils.equals(r100, "absent_user") == false) goto L17;
    L20:
        this.f508634d = r102;
        String r105 = "absent_user";
    L22:
        if (z.e(com.larksuite.framework.utils.b.f285948a) == false) goto L27;
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new c(this, r105, r101, r110, r111));
        return;
    L27:
        return;
    L17:
        if (TextUtils.isEmpty(r100) == true) goto L20;
        ((HashMap) this.f508635e).put(r100, r102);
        r105 = r100;
        goto L22
    }
}
