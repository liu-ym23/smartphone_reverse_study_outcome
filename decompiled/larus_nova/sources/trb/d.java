package trb;

import android.view.View;
import android.widget.TextView;
import com.ss.android.lark.message.vote.VoteCardOptionsAdapter;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes36.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TextView f547325a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f547326b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ irb.b f547327c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ VoteCardOptionsAdapter f547328d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ com.ss.android.lark.message.vote.c f547329e;

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f547325a.setEnabled(false);
        b r101 = this.f547326b;
        if (r101 == null) goto L20;
        String r102 = this.f547327c.f495560d;
        com.ss.android.lark.message.vote.c r103 = this.f547329e;
        VoteCardOptionsAdapter r104 = this.f547328d;
        r103.getClass();
        HashMap r105 = new HashMap();
        if (r104 == null) goto L13;
        Iterator<irb.a> r106 = r104.getItems().iterator();
    L9:
        if (r106.hasNext() == false) goto L13;
        irb.a r107 = r106.next();
        if (r107.f495552e == false) goto L9;
        r105.put(r107.f495549b, r107.f495550c);
    L13:
        ((com.ss.android.lark.message.vote.message.a) r101).a(r102, r105);
        return;
    }

    public d(com.ss.android.lark.message.vote.c r100, TextView r101, b r102, irb.b r103, VoteCardOptionsAdapter r104) {
        this.f547329e = r100;
        this.f547325a = r101;
        this.f547326b = r102;
        this.f547327c = r103;
        this.f547328d = r104;
    }
}
