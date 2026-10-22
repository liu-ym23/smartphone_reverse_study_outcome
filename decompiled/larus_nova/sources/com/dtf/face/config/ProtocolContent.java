package com.dtf.face.config;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.tencent.qqmusic.third.api.contract.Keys;
import faceverify.w;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes22.dex */
public class ProtocolContent {
    public AndroidClientConfig androidClientConfig;

    @JSONField(name = "androidcfg")
    public String androidcfg;

    @JSONField(name = "androiddoccfg")
    public String androiddoccfg;

    @JSONField(name = "androidvoicecfg")
    public String androidvoicecfg;
    public AndroidDocConfig docConfig;
    public OSSConfig dtOSSConfig;

    @JSONField(name = Keys.API_PARAM_KEY_SDK_EXPIRETIME)
    public String expireTime;

    @JSONField(name = "sampleMode")
    public int sampleMode;

    @JSONField(name = "solucfg")
    public String solucfg;
    public SolutionConfig solutionConfig;

    @JSONField(name = "token")
    public String token;

    @JSONField(name = "type")
    public int type;

    public Object getCurrentProtocol() {
        SolutionConfig r100 = this.solutionConfig;
        if (r100 == null) goto L19;
        List<String> r101 = r100.order;
        if (r101 == null) goto L19;
        if (r101.size() <= 0) goto L19;
        SolutionConfig r102 = this.solutionConfig;
        if (r102.currentConfigBizIndex >= r102.order.size()) goto L18;
        SolutionConfig r103 = this.solutionConfig;
        String r104 = (String) ListProtector.get(r103.order, r103.currentConfigBizIndex);
        if (w.BLOB_ELEM_TYPE_FACE.equals(r104) == false) goto L15;
        return this.androidClientConfig;
    L15:
        if ("doc".equals(r104) == false) goto L18;
        return this.docConfig;
    L18:
        return null;
    L19:
        AndroidDocConfig r105 = this.docConfig;
        if (r105 == null) goto L23;
        return r105;
    L23:
        return this.androidClientConfig;
    }

    public Object getNextProtocol() {
        SolutionConfig r100 = this.solutionConfig;
        if (r100 == null) goto L10;
        List<String> r101 = r100.order;
        if (r101 != null) goto L7;
        return null;
    L7:
        if (r101.size() <= 0) goto L13;
        this.solutionConfig.currentConfigBizIndex++;
        return getCurrentProtocol();
    L13:
        return null;
    L10:
        return null;
    }

    public boolean hasMultiProtocol() {
        SolutionConfig r100 = this.solutionConfig;
        if (r100 == null) goto L9;
        List<String> r101 = r100.order;
        if (r101 == null) goto L9;
        if (r101.size() <= 0) goto L9;
        return true;
    L9:
        return false;
    }

    public boolean hasNextProtocol() {
        SolutionConfig r100 = this.solutionConfig;
        if (r100 == null) goto L12;
        List<String> r101 = r100.order;
        if (r101 != null) goto L7;
        return false;
    L7:
        if (r101.size() <= 0) goto L14;
        SolutionConfig r102 = this.solutionConfig;
        if ((r102.currentConfigBizIndex + 1) >= r102.order.size()) goto L15;
        return true;
    L15:
        return false;
    L14:
        return false;
    L12:
        return false;
    }

    public boolean isValid() {
        if (this.androidClientConfig == null) goto L5;
    L8:
        return true;
    L5:
        if (this.docConfig != null) goto L8;
        return false;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void mergeExtAlgConfig() {
        AndroidClientConfig r100 = this.androidClientConfig;
        if (r100 != null) goto L5;
        return;
    L5:
        JSONObject r101 = r100.clientExtParams;
        if (r101 == null) goto L31;
        JSONObject r102 = r100.getAlgorithm();
        if (r102 == null) goto L47;
        Iterator<String> r103 = r101.keySet().iterator();
    L11:
        if (r103.hasNext() == false) goto L48;
        String r104 = r103.next();
        if (TextUtils.isEmpty(r104) == true) goto L11;
        if (r104.endsWith("_ALG_CONFIG") == false) goto L11;
        JSONObject r105 = JSON.parseObject(r101.getString(r104));     // Catch: Throwable -> L30
        Iterator<String> r106 = r105.keySet().iterator();     // Catch: Throwable -> L30
    L18:
        if (r106.hasNext() == false) goto L28;
        String r107 = r106.next();     // Catch: Throwable -> L30
        if (r102.get(r107) != null) goto L22;
    L25:
        boolean r108 = true;
    L26:
        if (r108 == false) goto L18;
        r102.put2(r107, r105.get(r107));     // Catch: Throwable -> L30
        goto L18
    L22:
        if (r102.get(r104).getClass() == r105.get(r104).getClass()) goto L25;
        r108 = false;
        goto L26
    L28:
        this.androidClientConfig.setAlgorithm(r102);     // Catch: Throwable -> L30
        goto L11
    L48:
        return;
    L47:
        return;
    }

    public String getCurrentProtocolName() {
        Object r100 = getCurrentProtocol();
        if (r100 != null) goto L5;
        return null;
    L5:
        if ((r100 instanceof AndroidClientConfig) == false) goto L9;
        return w.BLOB_ELEM_TYPE_FACE;
    L9:
        if ((r100 instanceof AndroidDocConfig) == false) goto L14;
        return "doc";
    L14:
        return null;
    }

    public ProtocolContent() {
    }

    public void parse(String r100) {
        this.androidClientConfig = (AndroidClientConfig) JSON.parseObject(this.androidcfg, AndroidClientConfig.class);
        SolutionConfig r101 = (SolutionConfig) JSON.parseObject(this.solucfg, SolutionConfig.class);
        this.solutionConfig = r101;
        if (r101 == null) goto L5;
        r101.fixValidConfig();
    L5:
        this.docConfig = (AndroidDocConfig) JSON.parseObject(this.androiddoccfg, AndroidDocConfig.class);
    }

    public void parseDTOSSConfig(String r100) {
        AndroidClientConfig r101 = this.androidClientConfig;
        if (r101 == null) goto L15;
        Upload r102 = r101.getUpload();
        if (r102 == null) goto L16;
        OSSConfig r103 = new OSSConfig();
        this.dtOSSConfig = r103;
        r103.OssEndPoint = r102.endpoint;
        r103.chameleonFileNamePrefix = r102.chameleonFileNamePrefix + r100;
        if (TextUtils.isEmpty(r102.bucket) == false) goto L9;
        this.dtOSSConfig.BucketName = "emptyBucketName";
    L10:
        OSSConfig r104 = this.dtOSSConfig;
        r104.AccessKeyId = r102.accessKeyId;
        r104.AccessKeySecret = r102.accessKeySecret;
        r104.SecurityToken = r102.securityToken;
        StringBuilder r105 = new StringBuilder();
        Object r106 = r102.collectFileNamePrefix;
        if (r106 != null) goto L13;
        r106 = Boolean.valueOf(r102.photinusVideo);
    L13:
        r105.append(r106);
        r105.append(r100);
        r104.FileNamePrefix = r105.toString();
        return;
    L9:
        this.dtOSSConfig.BucketName = r102.bucket;
        goto L10
    L16:
        return;
    }

    public void parseExtParams(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L13;
        AndroidClientConfig r101 = this.androidClientConfig;
        if (r101 == null) goto L14;
        r101.clientExtParamStr = r100;
        r101.clientExtParams = JSON.parseObject(r100).getJSONObject("wlclientcfg");     // Catch: Throwable -> L10
        return;
    L15:
        return;
    L14:
        return;
    }

    public void parseVoiceCfg(String r100) {
        if (TextUtils.isEmpty(this.androidvoicecfg) == false) goto L5;
        return;
    L5:
        VoiceConfig r101 = (VoiceConfig) JSON.parseObject(this.androidvoicecfg, VoiceConfig.class);
        if (r101 == null) goto L9;
        this.androidClientConfig.clientVoiceParamConfig = r101;
    L9:
        if (this.androidClientConfig == null) goto L17;
        if (r101 != null) goto L12;
        return;
    L12:
        if (r101.getNavi() != null) goto L14;
        return;
    L14:
        if (r101.getNavi().isEnable() == false) goto L20;
        this.androidClientConfig.setNavi(r101.getNavi());
        return;
    L20:
        return;
    }
}
