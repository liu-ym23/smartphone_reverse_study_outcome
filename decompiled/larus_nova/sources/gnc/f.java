package gnc;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;
import com.story.ai.biz.comment.bot.BotCommentDialogFragment;
import kotlin.jvm.internal.Intrinsics;
import v19.r5;

/* JADX INFO: loaded from: classes38.dex */
public final class f implements rq9.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BotCommentDialogFragment<rq9.d> f481865a;

    public f(BotCommentDialogFragment<rq9.d> r100) {
        this.f481865a = r100;
    }

    @Override // rq9.c
    public final void a(long r100) {
        this.f481865a.getClass();
        View r101 = this.f481865a.getView();
        if (r101 == null) goto L11;
        TextView r102 = (TextView) r101.findViewById(R.id.tv_comment_title);
        if (r102 == null) goto L12;
        BotCommentDialogFragment<rq9.d> r103 = this.f481865a;
        if (r100 > 0) goto L9;
        r102.setText(r102.getResources().getString(R.string.larus_botsComment_comment_title));
        return;
    L9:
        StringBuilder r104 = new StringBuilder();
        r104.append(r102.getResources().getString(R.string.larus_botsComment_comment_title));
        r104.append(' ');
        int r105 = r5.f552608a;
        r104.append(r5.a(r103.getContext(), r100));
        r102.setText(r104.toString());
        return;
    L12:
        return;
    }

    @Override // rq9.c
    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "draft");
        this.f481865a.getClass();
    }

    @Override // rq9.c
    public final void c(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
    }
}
