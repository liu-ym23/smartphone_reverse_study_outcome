package ql8;

import bc8.b;
import com.larus.im.bean.message.Message;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.larus.bmhome.chat.standarduikit.imagegroup.view.a f533813a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.larus.bmhome.chat.markdown.imagegroup.a f533814b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f533815c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f533816d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f533817e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f533818f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f533819g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Integer f533820h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function0<Map<String, Object>> f533821i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final b f533822j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Boolean f533823k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Function1<Integer, Unit> f533824l;

    public final Message a() {
        Object r100 = this.f533819g;
        if ((r100 instanceof Message) == true) goto L7;
        return null;
    L7:
        return (Message) r100;
    }

    public /* synthetic */ a(com.larus.bmhome.chat.standarduikit.imagegroup.view.a r110, int r111) {
        if ((r111 & 1) == 0) goto L5;
        com.larus.bmhome.chat.standarduikit.imagegroup.view.a r100 = new com.larus.bmhome.chat.standarduikit.imagegroup.view.a(0);
    L7:
        if ((r111 & 2) == 0) goto L9;
        com.larus.bmhome.chat.markdown.imagegroup.a r101 = new com.larus.bmhome.chat.markdown.imagegroup.a(null, null, null, null, 127);
    L10:
        this(r100, r101, null, null, null, null, null, null, null, null, null, null);
        return;
    L9:
        r101 = null;
        goto L10
    L5:
        r100 = r110;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(com.larus.bmhome.chat.standarduikit.imagegroup.view.a r100, com.larus.bmhome.chat.markdown.imagegroup.a r101, String r102, String r103, String r104, String r105, Object r106, Integer r107, Function0<? extends Map<String, ? extends Object>> r110, b r111, Boolean r112, Function1<? super Integer, Unit> r113) {
        Intrinsics.checkNotNullParameter(r100, "sizeData");
        Intrinsics.checkNotNullParameter(r101, "imageGroupData");
        this.f533813a = r100;
        this.f533814b = r101;
        this.f533815c = r102;
        this.f533816d = r103;
        this.f533817e = r104;
        this.f533818f = r105;
        this.f533819g = r106;
        this.f533820h = r107;
        this.f533821i = r110;
        this.f533822j = r111;
        this.f533823k = r112;
        this.f533824l = r113;
    }
}
