package kp1;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.core.element.ElementType;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ElementType f505490a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final jp1.b f505491b;

    public final ElementType getType() {
        return this.f505490a;
    }

    public a(ElementType r100, jp1.b r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        this.f505490a = r100;
        this.f505491b = r101;
    }
}
