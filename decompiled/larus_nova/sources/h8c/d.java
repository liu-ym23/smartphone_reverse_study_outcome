package h8c;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.larus.nova.R;
import com.ss.android.lark.todo.dependency.TodoDependencyHolder;
import com.ss.android.lark.todo.impl.utils.i;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class d extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f484306a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f484307b;

    public /* synthetic */ d(String r100) {
        this(r100, R.color.text_link_normal);
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        String r101 = this.f484306a;
        if (r101 == null) goto L6;
        TodoDependencyHolder.a().messengerModuleDependency().a(r100.getContext(), r101);
        return;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        Intrinsics.checkNotNullParameter(r100, "ds");
        r100.setColor(i.f444291a.a(this.f484307b));
    }

    public d(String r100, int r101) {
        this.f484306a = r100;
        this.f484307b = r101;
    }
}
