package fk6;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.live.richcontent.model.style.ImageStyle;
import ek6.c;
import ek6.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ek6.b f477652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageStyle f477653b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f477654c;

    public final String toString() {
        return "ImageContent[" + d() + ']';
    }

    @Override // ek6.d
    public final boolean a() {
        d().a();
        return false;
    }

    public c c() {
        return this.f477654c;
    }

    public ek6.b d() {
        return this.f477652a;
    }

    public ImageStyle e() {
        return this.f477653b;
    }

    public a(ek6.b r100, ImageStyle r101, c r102) {
        Intrinsics.checkNotNullParameter(r100, WsConstants.KEY_PAYLOAD);
        this.f477652a = r100;
        this.f477653b = r101;
        this.f477654c = r102;
    }
}
