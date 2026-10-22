package l2b;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import h7b.n;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a extends n {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function1<Chatter, Unit> f507190c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ChatChatter f507191d;

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        Function1<Chatter, Unit> r101 = this.f507190c;
        if (r101 == null) goto L6;
        r101.invoke(this.f507191d);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(int r100, Function1<? super Chatter, Unit> r101, ChatChatter r102, FragmentActivity r103) {
        this.f507190c = r101;
        this.f507191d = r102;
        super(r103, r100);
    }
}
