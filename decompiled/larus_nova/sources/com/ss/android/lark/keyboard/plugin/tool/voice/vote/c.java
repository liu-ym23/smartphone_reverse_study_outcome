package com.ss.android.lark.keyboard.plugin.tool.voice.vote;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes36.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DownVoteReasonAdapter.b f430842a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DownVoteReasonAdapter f430843b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ DownVoteReasonAdapter.DownVoteReasonViewHolder f430844c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f430845d;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DownVoteReasonAdapter f430846a;

        public a(DownVoteReasonAdapter r100) {
            this.f430846a = r100;
        }

        public final void a() {
            List<DownVoteReasonAdapter.b> r100 = this.f430846a.f430833b;
            ArrayList r101 = new ArrayList();
            Iterator<T> r102 = r100.iterator();
        L4:
            if (r102.hasNext() == false) goto L8;
            Object r103 = r102.next();
            if (((DownVoteReasonAdapter.b) r103).f430837c == false) goto L4;
            r101.add(r103);
            goto L4
        L8:
            int r104 = r101.size();
            Function1<Integer, Unit> r105 = this.f430846a.f430832a;
            if (r105 == null) goto L17;
            r105.invoke(Integer.valueOf(r104));
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public c(DownVoteReasonAdapter.b r100, DownVoteReasonAdapter r101, DownVoteReasonAdapter.DownVoteReasonViewHolder r102, int r103) {
        this.f430842a = r100;
        this.f430843b = r101;
        this.f430844c = r102;
        this.f430845d = r103;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        DownVoteReasonAdapter.b r101 = this.f430842a;
        boolean r102 = !r101.f430837c;
        r101.f430837c = r102;
        DownVoteReasonAdapter r103 = this.f430843b;
        AppCompatTextView r104 = this.f430844c.f430834a;
        int r105 = DownVoteReasonAdapter.f430831c;
        r103.getClass();
        DownVoteReasonAdapter.y2(r104, r102);
        this.f430843b.notifyItemChanged(this.f430845d);
        r100.post(new a(this.f430843b));
    }
}
