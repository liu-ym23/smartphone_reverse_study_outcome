package com.bytedance.pitaya.api.bean;

import com.bytedance.pitaya.jniwrapper.ReflectionCall;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b&\u0018\u0000 \u000f2\u00020\u0001:\u0003\u0010\u0011\u0012B\u0011\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/bytedance/pitaya/api/bean/PTYClass;", "Lcom/bytedance/pitaya/jniwrapper/ReflectionCall;", "", "toString", "", "classType", "I", "getClassType", "()I", "bindID", "Ljava/lang/String;", "getBindID$pitayacore_release", "()Ljava/lang/String;", "<init>", "(I)V", "Companion", "ClassType", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "DataDeliverType", "pitayacore_release"}, k = 1, mv = {1, 7, 1})
public abstract class PTYClass implements ReflectionCall {
    public static final int CLASS_TYPE_COUNT = 4;
    public static final a Companion = null;
    public static final int ORIGIN_TYPE_BYTE_ARRAY = 2;
    public static final int ORIGIN_TYPE_FLOAT_ARRAY = 3;
    public static final int PTY_CLASS_MEMORY_VIEW = 1;
    public static final int PTY_CLASS_MOBILE_CVMAT = 2;
    public static final int PTY_CLASS_ND_ARRAY = 3;
    public static final int PTY_CLASS_TENSOR = 0;
    private final String bindID;
    private final int classType;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/pitaya/api/bean/PTYClass$ClassType;", "", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface ClassType {
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/pitaya/api/bean/PTYClass$DataDeliverType;", "", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface DataDeliverType {
    }

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public PTYClass() {
        int r100 = 0;
        this(r100, 1, null);
    }

    public final String getBindID$pitayacore_release() {
        return this.bindID;
    }

    public final int getClassType() {
        return this.classType;
    }

    public String toString() {
        return this.bindID;
    }

    public PTYClass(int r100) {
        this.classType = r100;
        this.bindID = UUID.randomUUID().toString();
    }

    public /* synthetic */ PTYClass(int r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = 4;
    L5:
        this(r100);
    }
}
