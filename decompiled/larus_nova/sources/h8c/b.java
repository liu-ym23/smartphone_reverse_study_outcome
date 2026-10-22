package h8c;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.todo.impl.features.chatlist.mvvm.TaskContainerListActivity;
import com.ss.android.lark.todo.impl.utils.i;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class b extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f484300a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f484301b;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f484302a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Intent f484303b;

        public a(View r100, Intent r101) {
            this.f484302a = r100;
            this.f484303b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f484302a.getContext().startActivity(this.f484303b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public b(String r100) {
        this.f484300a = r100;
        this.f484301b = R.color.text_link_normal;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        if (this.f484300a == null) goto L9;
        Context r101 = r100.getContext();
        int r102 = TaskContainerListActivity.f442270a;
        Intent r103 = new Intent(r101, TaskContainerListActivity.a.a()).putExtra("task_container_guid", this.f484300a);
        if ((r100.getContext() instanceof Activity) == true) goto L7;
        r103.addFlags(268435456);
    L7:
        com.bytedance.ee.lark.infra.foundation.utils.c.a(new a(r100, r103));
        return;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        Intrinsics.checkNotNullParameter(r100, "ds");
        r100.setColor(i.f444291a.a(this.f484301b));
    }
}
