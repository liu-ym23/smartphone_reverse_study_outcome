package i18;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.larksuite.framework.apiplugin.LKEvent;
import com.larksuite.framework.apiplugin.annotation.LKPluginFunction;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import com.larksuite.framework.apiplugin.entity.LKBasePluginResult;
import com.larksuite.framework.apiplugin.entity.LKPluginHandleResult;
import com.larksuite.framework.apiplugin.validator.IllegalValidatorException;
import com.ss.android.lark.log.Log;
import j18.e;
import j18.k;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes24.dex */
public abstract class b extends d {
    private static final String ERROR_NO = "errno";
    private static final String ERROR_STRING = "errString";
    private static final String ERR_MSG = "errMsg";
    private static final String TAG = "AutoRegisterLKPlugin";
    private Map<String, us5.b> mEvent2Method;
    private final AtomicBoolean mIsInit;

    public static /* synthetic */ void b(b r100, LKEvent r101, Method r102) {
        r100.lambda$asyncHandle$0(r101, r102);
    }

    private void checkInit() {
        if (this.mIsInit.get() == false) goto L5;
        return;
    L5:
        this.mIsInit.set(true);
        q18.a r100 = q18.a.C7269a.f531312a;
        Class<?> r101 = getClass();
        Map<String, us5.b> r102 = (Map) ((ConcurrentHashMap) r100.f531311b).get(r101);
        if (r102 != null) goto L8;
    L21:
        Method[] r103 = getClass().getDeclaredMethods();
        HashMap r104 = new HashMap();
        if (r103 == null) goto L33;
        int r105 = r103.length;
        int r106 = 0;
    L24:
        if (r106 >= r105) goto L33;
        Method r107 = r103[r106];
        LKPluginFunction r108 = (LKPluginFunction) r107.getAnnotation(LKPluginFunction.class);
        if (r108 == null) goto L32;
        if (q18.c.b(r107) == false) goto L32;
        boolean r109 = r108.async();
        us5.b r110 = new us5.b();
        r110.f551512a = r107;
        r110.f551513b = r109;
        String[] r111 = r108.eventName();
        int r112 = r111.length;
        int r113 = 0;
    L30:
        if (r113 >= r112) goto L32;
        r104.put(r111[r113], r110);
        r113 = r113 + 1;
    L32:
        r106 = r106 + 1;
    L33:
        q18.a r114 = q18.a.C7269a.f531312a;
        Class<?> r115 = getClass();
        Map r116 = (Map) ((ConcurrentHashMap) r114.f531311b).get(r115);
        if (r116 != null) goto L36;
        r116 = new HashMap();
    L36:
        Iterator r117 = r104.entrySet().iterator();
    L38:
        if (r117.hasNext() == false) goto L40;
        Map.Entry r118 = (Map.Entry) r117.next();
        r116.put((String) r118.getKey(), (us5.b) r118.getValue());
        goto L38
    L40:
        ((ConcurrentHashMap) r114.f531311b).put(r115, r116);
        this.mEvent2Method = r104;
        return;
    L8:
        if (r102.isEmpty() == true) goto L21;
        Iterator<Map.Entry<String, us5.b>> r119 = r102.entrySet().iterator();
    L11:
        if (r119.hasNext() == false) goto L19;
        Map.Entry<String, us5.b> r120 = r119.next();
        if (r120 == null) goto L11;
        if (r120.getValue() == null) goto L11;
        if (q18.c.b(r120.getValue().f551512a) == true) goto L11;
        r119.remove();
        goto L11
    L19:
        this.mEvent2Method = r102;
    }

    public JSONObject generateParamsInvalidResult() {
        k18.a r100 = k18.a.f501383c;
        return generateResult("invalid parameter");
    }

    public b() {
        this.mEvent2Method = Collections.EMPTY_MAP;
        this.mIsInit = new AtomicBoolean(false);
        checkInit();
    }

    private JSONObject createErrMsgJSONObject(String r100) {
        JSONObject r101 = new JSONObject();
        r101.put("errMsg", r100);     // Catch: JSONException -> L5
    L7:
        return r101;
    L5:
        e = move-exception;
        Log.e(TAG, "createErrMsgJSONObject Exception", e);
        goto L7
    }

    private JSONObject generateResult(String r100) {
        JSONObject r101 = new JSONObject();
        r101.put("errMsg", r100);     // Catch: JSONException -> L5
        return r101;
    L5:
        e = move-exception;
        Log.e(TAG, "put errMsg jsonException: " + e.getMessage());
        return r101;
    }

    private String generateThrowableExtraInfo(Throwable r100) {
        if ((r100 instanceof InvocationTargetException) == false) goto L8;
        Throwable r101 = ((InvocationTargetException) r100).getTargetException();
        if (r101 == null) goto L8;
        r100 = r101;
    L8:
        Object[] r102 = new Object[2];
        int r103 = 0;
        r102[0] = r100;
        StackTraceElement[] r104 = r100.getStackTrace();
        StringBuilder r105 = new StringBuilder();
        int r106 = 5;
        if (5 <= r104.length) goto L12;
        r106 = r104.length;
    L12:
        if (r106 <= 0) goto L17;
        r105.append(r104[0]);
    L14:
        r103 = r103 + 1;
        if (r103 >= r106) goto L17;
        r105.append(" ");
        r105.append(r104[r103]);
    L17:
        r102[1] = r105.toString();
        return String.format("native exception %s stack:%s", r102);
    }

    @Override // i18.d
    public void addEvents(e r100) {
        checkInit();
        Map<String, us5.b> r101 = this.mEvent2Method;
        if (r101 == null) goto L8;
        Iterator<String> r102 = r101.keySet().iterator();
    L6:
        if (r102.hasNext() == false) goto L10;
        String r103 = r102.next();
        ((ArrayList) ((l18.d) r100).f507019a).add(r103);
        goto L6
    L10:
        return;
    }

    public LKBaseResponseModel generateParamsInvalidResponse(String r100) {
        return generateResponse(r100, k18.a.f501385e);
    }

    @Override // i18.d, j18.g
    public LKPluginHandleResult handleEvent(LKEvent r100) {
        String r101 = r100.f285488a;
        Map<String, us5.b> r102 = this.mEvent2Method;
        if (r102 == null) goto L16;
        us5.b r103 = r102.get(r101);
        if (r103 == null) goto L18;
        Method r104 = r103.f551512a;     // Catch: Exception -> L14
        if (r103.f551513b == false) goto L13;
        if (asyncHandle(r100, r101, r104) == true) goto L18;
        return LKPluginHandleResult.f285532g;
    L13:
        return syncHandle(r100, r104, r101);
    L14:
        e = move-exception;
        Log.e(TAG, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION, e);
    L18:
        return super.handleEvent(r100);
    L16:
        Log.e(TAG, "handleEvent mEvent2Method is null", new Throwable());
        goto L18
    }

    private LKBaseResponseModel generateResponse(String r100, k18.a r101) {
        LKBaseResponseModel r102 = new LKBaseResponseModel(r101);
        r102.mInnerMsg = r100;
        return r102;
    }

    private JSONObject generateResult(String r100, n18.b r101) {
        JSONObject r102 = new JSONObject();
        r102.put("errMsg", r100);     // Catch: JSONException -> L9
        if (r101 == null) goto L8;
        int r103 = r101.f516675a;     // Catch: JSONException -> L9
        if (r103 == 0) goto L8;
        r102.put("errno", r103);     // Catch: JSONException -> L9
        r102.put("errString", r101.f516676b);     // Catch: JSONException -> L9
    L8:
        return r102;
    L9:
        e = move-exception;
        Log.e(TAG, "put errMsg jsonException: " + e.getMessage());
        return r102;
    }

    private /* synthetic */ void lambda$asyncHandle$0(LKEvent r100, Method r101) {
        asyncHandleImpl(r100, r101);
    }

    public void asyncHandleImpl(LKEvent r100, Method r101) {
        s18.b r102 = q18.c.a(r100, r101);     // Catch: Exception -> L29 IllegalValidatorException -> L32
        if (r102.f540179a == true) goto L16;
        LKBaseResponseModel r103 = generateParamsInvalidResponse(r102.f540180b);     // Catch: Exception -> L29 IllegalValidatorException -> L32
        if (TextUtils.equals(r102.f540181c, "no_require_params") == false) goto L8;
        r103.setApiErrNo(new o18.a(104, String.format("Parameter error. %s cannot be empty", new Object[]{r102.f540182d})));     // Catch: Exception -> L29 IllegalValidatorException -> L32
    L13:
        r100.b(r103);     // Catch: Exception -> L29 IllegalValidatorException -> L32
        return;
    L8:
        if (TextUtils.equals(r102.f540181c, "illegal_value") == false) goto L11;
        r103.setApiErrNo(new o18.a(104, String.format("Parameter error. Invalid value for %s", new Object[]{r102.f540182d})));     // Catch: Exception -> L29 IllegalValidatorException -> L32
        goto L13
    L11:
        if (TextUtils.equals(r102.f540181c, "illegal_params_type") == false) goto L13;
        r103.setApiErrNo(new o18.a(104, String.format("Parameter error. %s is of wrong type", new Object[]{r102.f540182d})));     // Catch: Exception -> L29 IllegalValidatorException -> L32
        goto L13
    L16:
        if (r102.f540183e == null) goto L18;
        r100.f285489b = new JSONObject(r102.f540183e);     // Catch: Exception -> L29 IllegalValidatorException -> L32
    L18:
        Object[] r104 = q18.c.c(r100, r101);     // Catch: Exception -> L29 IllegalValidatorException -> L32
        monitor-enter(this);     // Catch: Exception -> L26
        r101.invoke(this, r104);     // Catch: Throwable -> L23
        monitor-exit(this);     // Catch: Throwable -> L23
    L39:
        return;
    L23:
        th = move-exception;
        throw th;     // Catch: Exception -> L26
    L26:
        e = move-exception;
        Log.e(TAG, "invoke Exception: ", e);
        r100.b(generateResponse(generateThrowableExtraInfo(e), k18.a.f501383c));
        return;
    L32:
        e = move-exception;
        Log.e(TAG, "validator invalid", e);
        r100.b(generateResponse(e.getMessage(), k18.a.f501384d));
        return;
    L29:
        e = move-exception;
        Log.e(TAG, "async JSON.parseObject error", e);
        r100.b(generateResponse(e.getMessage(), k18.a.f501385e));
    }

    public JSONObject generateParamsInvalidResult(String r100, String r101) {
        if (TextUtils.equals(r100, "no_require_params") == false) goto L6;
        o18.a r102 = new o18.a(104, String.format("Parameter error. %s cannot be empty", new Object[]{r101}));
    L12:
        k18.a r103 = k18.a.f501383c;
        return generateResult("invalid parameter", r102);
    L6:
        if (TextUtils.equals(r100, "illegal_value") == false) goto L9;
        r102 = new o18.a(104, String.format("Parameter error. Invalid value for %s", new Object[]{r101}));
        goto L12
    L9:
        if (TextUtils.equals(r100, "illegal_params_type") == false) goto L11;
        r102 = new o18.a(104, String.format("Parameter error. %s is of wrong type", new Object[]{r101}));
        goto L12
    L11:
        r102 = o18.a.f521724c;
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [i18.a] */
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
    private boolean asyncHandle(final LKEvent r100, String r101, final Method r102) {
        if (r100.f285498k == null) goto L5;
    L17:
        j18.a r103 = r100.f285498k;
        if (r103 == 0) goto L21;
        r103.a(r101, new a(this, r100, r102));
        return true;
    L21:
        Log.e(TAG, "lkAsyncHandleEventExecutor is null,proceed handle");
        return false;
    L5:
        if (l18.b.f507017b == null) goto L7;
    L16:
        r100.f285498k = l18.b.f507017b;
        goto L17
    L7:
        monitor-enter(l18.b.class);
    L13:
        th = move-exception;
        throw th;
    L9:
        if (l18.b.f507017b != null) goto L11;
        l18.b.f507017b = new l18.b();     // Catch: Throwable -> L13
    L11:
        monitor-exit(l18.b.class);     // Catch: Throwable -> L13
        goto L16
    }

    private LKPluginHandleResult createFailResult(LKEvent r100, int r101, String r102) {
        JSONObject r103 = createErrMsgJSONObject(r102);
        r100.getClass();
        return LKEvent.d(r101, r103);
    }

    private LKPluginHandleResult getSyncHandleResult(LKEvent r100, String r101, Object r110) {
        if ((r110 instanceof LKPluginHandleResult) == true) goto L5;
        boolean r102 = true;
        if ((r110 instanceof LKBaseResponseModel) == false) goto L34;
        LKBaseResponseModel r103 = (LKBaseResponseModel) r110;
        if (r103.getApiErrCode() != null) goto L12;
        k18.a r104 = k18.a.f501383c;
        return createFailResult(r100, 102, "apiErrCode cannot be null");
    L12:
        String r105 = JSON.toJSONString(r110);
        LKPluginHandleResult.a r106 = new LKPluginHandleResult.a();
        JSONObject r107 = new JSONObject(r105);     // Catch: JSONException -> L30
        r18.b.a(r107, (LKBaseResponseModel) r110);     // Catch: JSONException -> L30
        r106.f285525a = r107;     // Catch: JSONException -> L30
        r107.put("errMsg", r18.b.c(r103));     // Catch: JSONException -> L30
        if (r103.isFail() == false) goto L16;
        r106.f285527c = r103.getApiErrCode().f516673a;     // Catch: JSONException -> L30
    L18:
        if (r103.mIsArrayBuffer == true) goto L20;
    L22:
        r102 = false;
    L23:
        if (r102 == false) goto L28;
        Log.i(TAG, "eventName:" + r101 + " is arrayBuffer");
        List<LKBasePluginResult.b.a> r108 = r103.getArrayBuffers();
        if (r106.f285528d != null) goto L27;
        r106.f285528d = new ArrayList();
    L27:
        ((ArrayList) r106.f285528d).addAll(r108);
    L28:
        r106.f285533e = r103.isCease();
        return new LKPluginHandleResult(r106);
    L20:
        if (r103.getArrayBuffers() == null) goto L22;
    L16:
        r107.remove("errno");     // Catch: JSONException -> L30
        r107.remove("errString");     // Catch: JSONException -> L30
    L30:
        e = move-exception;
        Log.e(TAG, "JSONException when new JSONObject", e);
        k18.a r111 = k18.a.f501383c;
        return createFailResult(r100, 102, e.getMessage());
    L34:
        if ((r110 instanceof k) == false) goto L43;
        r100.getClass();
        LKPluginHandleResult.a r109 = new LKPluginHandleResult.a();
        r109.f285526b = (k) r110;
        r109.f285527c = Integer.MIN_VALUE;
        r109.f285533e = true;
        return new LKPluginHandleResult(r109);
    L43:
        JSONObject r112 = new JSONObject(JSON.toJSONString(r110));     // Catch: JSONException -> L40
        r100.a(r112);     // Catch: JSONException -> L40
        return LKEvent.d(Integer.MIN_VALUE, r112);
    L40:
        e = move-exception;
        Log.e(TAG, "JSONException", e);
        k18.a r113 = k18.a.f501383c;
        return createFailResult(r100, 102, e.getMessage());
    L5:
        return (LKPluginHandleResult) r110;
    }

    public <T extends LKBaseResponseModel> void fillFailedResponse(T r100, n18.a r101, String r102) {
        if (r100 == null) goto L6;
        r100.mInnerMsg = r102;
        r100.setApiErrCode(r101);
        return;
    }

    public LKPluginHandleResult syncHandle(LKEvent r100, Method r101, String r102) {
        s18.b r103 = q18.c.a(r100, r101);     // Catch: Exception -> L16 IllegalValidatorException -> L19
        if (r103.f540179a == true) goto L8;
        Log.i(TAG, "invalid params");     // Catch: Exception -> L16 IllegalValidatorException -> L19
        k18.a r104 = k18.a.f501383c;     // Catch: Exception -> L16 IllegalValidatorException -> L19
        JSONObject r105 = generateParamsInvalidResult(r103.f540181c, r103.f540182d);     // Catch: Exception -> L16 IllegalValidatorException -> L19
        r100.getClass();     // Catch: Exception -> L16 IllegalValidatorException -> L19
        return LKEvent.d(104, r105);
    L8:
        if (r103.f540183e == null) goto L22;
        r100.f285489b = new JSONObject(r103.f540183e);     // Catch: Exception -> L16 IllegalValidatorException -> L19
    L22:
        return getSyncHandleResult(r100, r102, r101.invoke(this, q18.c.c(r100, r101)));
    L13:
        e = move-exception;
        Log.e(TAG, "You added the LKPluginFunction annotation to the relevant method of the plugin, but the method call failed ：", e);
        k18.a r106 = k18.a.f501383c;
        return createFailResult(r100, 101, "unknown exception");
    L19:
        e = move-exception;
        Log.e(TAG, "validator invalid", e);
        k18.a r107 = k18.a.f501383c;
        JSONObject r108 = generateResult("internal error");
        r100.getClass();
        return LKEvent.d(102, r108);
    L16:
        e = move-exception;
        Log.e(TAG, "Exception", e);
        k18.a r109 = k18.a.f501383c;
        JSONObject r110 = generateParamsInvalidResult();
        r100.getClass();
        return LKEvent.d(104, r110);
    }

    public <T extends LKBaseResponseModel> void fillFailedResponse(T r100, n18.a r101, String r102, n18.b r103) {
        if (r100 == null) goto L6;
        r100.mInnerMsg = r102;
        r100.setApiErrCode(r101);
        r100.setApiErrNo(r103);
        return;
    }
}
