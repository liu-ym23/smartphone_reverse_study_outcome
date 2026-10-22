package kotlinx.datetime.internal.format.parser;

import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class c0<Output> implements r<Output> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<Output, Unit> f505307a;

    public c0(kotlinx.datetime.internal.format.r r100) {
        Intrinsics.checkNotNullParameter(r100, WikiFolderPushPlugin.OPT);
        this.f505307a = r100;
    }

    @Override // kotlinx.datetime.internal.format.parser.r
    public final Object a(c r100, CharSequence r101, int r102) {
        Intrinsics.checkNotNullParameter(r101, "input");
        this.f505307a.invoke(r100);
        int r103 = l.f505334a;
        return Integer.valueOf(r102);
    }
}
