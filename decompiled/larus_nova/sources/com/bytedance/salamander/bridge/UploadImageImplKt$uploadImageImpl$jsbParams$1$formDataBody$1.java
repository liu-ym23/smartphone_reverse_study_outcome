package com.bytedance.salamander.bridge;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.salamander.anniex.z2;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\r\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004*\u0001\u0002\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/salamander/anniex/z2;", "formDataReq", "com/bytedance/salamander/bridge/UploadImageImplKt$uploadImageImpl$jsbParams$1$formDataBody$1$a", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/salamander/anniex/z2;)Lcom/bytedance/salamander/bridge/UploadImageImplKt$uploadImageImpl$jsbParams$1$formDataBody$1$a;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
final class UploadImageImplKt$uploadImageImpl$jsbParams$1$formDataBody$1 extends Lambda implements Function1<z2, a> {
    public static final UploadImageImplKt$uploadImageImpl$jsbParams$1$formDataBody$1 INSTANCE = null;

    public static final class a implements yd7.i.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f268547a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f268548b;

        @Override // com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel
        public final Map<String, Object> convert() {
            throw new NotImplementedError("An operation is not implemented: Not yet implemented");
        }

        @Override // com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel
        public final JSONObject toJSON() {
            throw new NotImplementedError("An operation is not implemented: Not yet implemented");
        }

        @Override // yd7.i.b
        public final String getKey() {
            return this.f268547a;
        }

        @Override // yd7.i.b
        public final String getValue() {
            return this.f268548b;
        }

        public a(z2 r100) {
            this.f268547a = r100.f268536a;
            this.f268548b = r100.f268537b;
        }
    }

    static {
        INSTANCE = new UploadImageImplKt$uploadImageImpl$jsbParams$1$formDataBody$1();
    }

    public UploadImageImplKt$uploadImageImpl$jsbParams$1$formDataBody$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final a invoke2(z2 r100) {
        Intrinsics.checkNotNullParameter(r100, "formDataReq");
        return new a(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ a invoke(z2 r100) {
        return invoke2(r100);
    }
}
