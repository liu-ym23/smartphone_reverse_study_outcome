package mec;

import com.ss.android.lark.widget.richtext.preprocess.b;
import com.ss.android.lark.widget.span.InlineCodeInfo;
import java.util.Stack;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a extends lec.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b.InterfaceC5430b f513587a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Stack<InlineCodeInfo> f513588b;

    public a(b.InterfaceC5430b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f513587a = r100;
        this.f513588b = new Stack();
    }
}
