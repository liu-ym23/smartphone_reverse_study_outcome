package com.larksuite.framework.apiplugin.common;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.larksuite.framework.apiplugin.annotation.LKIncludeWithFailData;
import com.larksuite.framework.apiplugin.entity.LKBasePluginResult;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import n18.a;
import n18.b;
import org.json.JSONException;
import org.json.JSONObject;
import q18.c;

/* JADX INFO: loaded from: classes24.dex */
@JSONType(ignores = {"success", "fail"})
public class LKBaseResponseModel extends LKBaseModel {
    private static final String API_ERR_NO = "apiErrNo";
    public static final a DEFAULT_API_ERR_CODE = null;
    private static final a DEFAULT_API_ERR_CODE_FOR_ERRNO = null;
    public static final int DEFAULT_ERROR_CODE = Integer.MIN_VALUE;
    public static final int DEFAULT_ERR_NO = 0;
    public static final String ERROR_MSG_KEY = "errMsg";
    public static final String ERROR_NO_KEY = "errno";
    public static final String ERROR_STRING_KEY = "errString";
    public static final String INNER_CODE_KEY = "innerCode";
    public static final String INNER_MSG_KEY = "innerMsg";
    public static final String KEY_NATIVE_BUFFER = "__nativeBuffers__";
    private static final String TAG = "LKBaseResponseModel";

    @JSONField(serialize = false)
    private a apiErrCode;

    @JSONField(serialize = false)
    private String customErrMsg;
    private int errNo;
    private String errString;

    @JSONField(name = KEY_NATIVE_BUFFER)
    private List<LKBasePluginResult.b.a> mArrayBuffers;

    @JSONField(name = INNER_MSG_KEY)
    public String mInnerMsg;

    @JSONField(serialize = false)
    public boolean mIsArrayBuffer;

    @JSONField(serialize = false)
    private boolean mIsCease;
    private List<String> mRemovedParams;

    @JSONField(serialize = false)
    private boolean optimizeJsonParse;

    @JSONField(serialize = false)
    private SerializeFilter serializeFilter;

    public void proceed() {
        this.mIsCease = false;
    }

    static {
        DEFAULT_API_ERR_CODE = new a(Integer.MIN_VALUE, null);
        DEFAULT_API_ERR_CODE_FOR_ERRNO = new a(Integer.MIN_VALUE, "please check errno");
    }

    private void copyCommonCode2errno() {
        a r100 = this.apiErrCode;
        int r101 = r100.f516673a;
        if (r101 >= 100) goto L5;
        return;
    L5:
        if (r101 >= 999) goto L33;
        o18.a r102 = o18.a.f521724c;
        if (r101 != 100) goto L9;
        setApiErrNo(r102);
        return;
    L9:
        o18.a r103 = o18.a.f521725d;
        if (r101 != 101) goto L12;
        setApiErrNo(r103);
        return;
    L12:
        o18.a r104 = o18.a.f521726e;
        if (r101 != 102) goto L15;
        setApiErrNo(r104);
        return;
    L15:
        o18.a r105 = o18.a.f521727f;
        if (r101 != 103) goto L18;
        setApiErrNo(r105);
        return;
    L18:
        o18.a r106 = o18.a.f521728g;
        if (r101 != 105) goto L21;
        setApiErrNo(r106);
        return;
    L21:
        o18.a r107 = o18.a.f521729h;
        if (r101 != 106) goto L24;
        setApiErrNo(r107);
        return;
    L24:
        o18.a r108 = o18.a.f521730i;
        if (r101 != 107) goto L27;
        setApiErrNo(r108);
        return;
    L27:
        o18.a r109 = o18.a.f521731j;
        if (r101 != 108) goto L30;
        setApiErrNo(r109);
        return;
    L30:
        setApiErrNo(new b(r101, r100.f516674b));
        return;
    }

    public b getApiErrNo() {
        int r100 = this.errNo;
        if (r100 != 0) goto L5;
        return null;
    L5:
        return new b(r100, this.errString);
    }

    public boolean isSuccess() {
        a r100 = this.apiErrCode;
        if (r100 != null) goto L5;
    L9:
        return false;
    L5:
        if (r100.f516673a != Integer.MIN_VALUE) goto L9;
        if (this.errNo != 0) goto L9;
        return true;
    }

    public LKBaseResponseModel() {
        this.apiErrCode = DEFAULT_API_ERR_CODE;
        this.errNo = 0;
        this.errString = "";
        this.optimizeJsonParse = false;
        this.mIsCease = true;
        this.mIsArrayBuffer = false;
        this.mRemovedParams = new ArrayList();
    }

    private boolean hasExtraFailData() {
        if (getClass().getAnnotation(LKIncludeWithFailData.class) != null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isFail() {
        return !isSuccess();
    }

    public JSONObject toJSONObject() {
    L17:
        e = move-exception;
        JSONObject r100 = new JSONObject();
        Log.e(TAG, "toJSONObject error", e);
        return r100;
    L3:
        if (optimizeJsonParse() == false) goto L6;
        JSONObject r101 = r18.a.a((com.alibaba.fastjson.JSONObject) JSON.toJSON(this));     // Catch: JSONException -> L17
    L10:
        if (isFail() == true) goto L12;
        r101.remove(INNER_CODE_KEY);     // Catch: JSONException -> L17
        r101.remove(ERROR_NO_KEY);     // Catch: JSONException -> L17
        r101.remove(ERROR_STRING_KEY);     // Catch: JSONException -> L17
        return r101;
    L12:
        if (hasExtraFailData() == true) goto L21;
        r101.remove(API_ERR_NO);     // Catch: JSONException -> L17
        return r101;
    L21:
        return c.d(this);
    L6:
        if (getSerializeFilter() == null) goto L8;
        r101 = new JSONObject(JSON.toJSONString(this, getSerializeFilter(), new SerializerFeature[0]));     // Catch: JSONException -> L17
        goto L10
    L8:
        r101 = new JSONObject(JSON.toJSONString(this));     // Catch: JSONException -> L17
        goto L10
    }

    public List<String> findRemovedParams() {
        return this.mRemovedParams;
    }

    public a getApiErrCode() {
        return this.apiErrCode;
    }

    public List<LKBasePluginResult.b.a> getArrayBuffers() {
        return this.mArrayBuffers;
    }

    public String getCustomErrMsg() {
        return this.customErrMsg;
    }

    @JSONField(name = ERROR_NO_KEY)
    public int getErrNo() {
        return this.errNo;
    }

    @JSONField(name = ERROR_STRING_KEY)
    public String getErrString() {
        return this.errString;
    }

    public SerializeFilter getSerializeFilter() {
        return this.serializeFilter;
    }

    public boolean isCease() {
        return this.mIsCease;
    }

    public boolean optimizeJsonParse() {
        return this.optimizeJsonParse;
    }

    public LKBaseResponseModel(a r100) {
        this.apiErrCode = DEFAULT_API_ERR_CODE;
        this.errNo = 0;
        this.errString = "";
        this.optimizeJsonParse = false;
        this.mIsCease = true;
        this.mIsArrayBuffer = false;
        this.mRemovedParams = new ArrayList();
        Intrinsics.checkNotNull(r100);
        this.apiErrCode = r100;
        copyCommonCode2errno();
    }

    public void addArrayBuffer(LKBasePluginResult.b.a r100) {
        if (this.mArrayBuffers != null) goto L5;
        this.mArrayBuffers = new ArrayList();
    L5:
        this.mArrayBuffers.add(r100);
    }

    public void addRemovedParams(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        List<String> r101 = this.mRemovedParams;
        if (r101 != null) goto L9;
        return;
    L9:
        if (r101.contains(r100) == false) goto L11;
        return;
    L11:
        this.mRemovedParams.add(r100);
    }

    public void setApiErrCode(a r100) {
        this.apiErrCode = r100;
        copyCommonCode2errno();
    }

    public void setApiErrNo(b r100) {
        if (r100 == null) goto L7;
        this.errNo = r100.f516675a;
        this.errString = r100.f516676b;
        if (this.apiErrCode != DEFAULT_API_ERR_CODE) goto L8;
        this.apiErrCode = DEFAULT_API_ERR_CODE_FOR_ERRNO;
        return;
    L8:
        return;
    }

    public void setCustomErrMsg(String r100) {
        this.customErrMsg = r100;
    }

    public void setOptimizeJsonParse(boolean r100) {
        this.optimizeJsonParse = r100;
    }

    public void setSerializeFilter(SerializeFilter r100) {
        this.serializeFilter = r100;
    }
}
