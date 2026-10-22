package fk6;

import com.bytedance.common.wschannel.WsConstants;
import ek6.c;
import ek6.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public class b implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f477655a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final gk6.a f477656b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f477657c;

    @Override // ek6.d
    public final boolean a() {
        return false;
    }

    public final String toString() {
        return "TextContent[" + c() + ']';
    }

    public c b() {
        return this.f477657c;
    }

    public String c() {
        return this.f477655a;
    }

    public gk6.a d() {
        return this.f477656b;
    }

    public b(String r100, gk6.a r101, c r102) {
        Intrinsics.checkNotNullParameter(r100, WsConstants.KEY_PAYLOAD);
        this.f477655a = r100;
        this.f477656b = r101;
        this.f477657c = r102;
    }
}
