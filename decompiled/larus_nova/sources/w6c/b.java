package w6c;

import android.content.Context;
import android.content.DialogInterface;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.component.ui.dialog.LKUIDialog;
import com.larus.nova.R;
import com.ss.android.lark.thirdshare.base.export.ShareActionType;
import com.ss.android.lark.thirdshare.base.export.ShareEntity;
import com.ss.android.lark.thirdshare.base.export.item.BaseItemAdapter;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes38.dex */
public final class b implements w6c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f558473a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LKUIDialog f558474b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ShareEntity f558475c;

    public class a extends com.larksuite.component.ui.dialog.d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f558476a;

        public a(b r100) {
            this.f558476a = r100;
        }

        @Override // com.larksuite.component.ui.dialog.d.a
        public final void b(LKUIDialog r100) {
            b r101 = this.f558476a;
            ShareEntity r102 = r101.f558475c;
            int r103 = e.f558482g;
            ArrayList r104 = new ArrayList();
            Iterator<ShareActionType> r105 = r102.getShareActionTypes().iterator();
        L4:
            if (r105.hasNext() == false) goto L8;
            ShareActionType.ShareItemInfo r106 = r105.next().getShareItemInfo();
            if (r106 == null) goto L4;
            r104.add(new e(r102, r106, r101));
            goto L4
        L8:
            RecyclerView r107 = (RecyclerView) r100.findViewById(R.id.tsShareRv);
            TextView r108 = (TextView) r100.findViewById(R.id.tsShareCancelTv);
            BaseItemAdapter r109 = new BaseItemAdapter();
            r109.f441215a = r104;
            r107.setAdapter(r109);
            r107.setLayoutManager(new LinearLayoutManager(r100.getContext(), 0, false));
            r108.setOnClickListener(new c(r101, r100));
        }
    }

    /* JADX INFO: renamed from: w6c.b$b, reason: collision with other inner class name */
    public class DialogInterfaceOnDismissListenerC8077b implements DialogInterface.OnDismissListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f558477a;

        public DialogInterfaceOnDismissListenerC8077b(b r100) {
            this.f558477a = r100;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface r100) {
            if (this.f558477a.f558475c.getCallback() == null) goto L6;
            this.f558477a.f558475c.getCallback().onDismiss(this.f558477a.f558473a);
            return;
        }
    }

    public b(Context r100, ShareEntity r101) {
        this.f558475c = r101;
        com.larksuite.component.ui.dialog.d r102 = new com.larksuite.component.ui.dialog.d(r100);
        r102.f284132c.width(1.0f);
        r102.e(80);
        r102.f284132c.marginInDp(0);
        r102.f284132c.rootLayoutRes(R.layout.ts_share_dialog);
        DialogInterfaceOnDismissListenerC8077b r103 = new DialogInterfaceOnDismissListenerC8077b(this);
        r102.f284132c.onDismissListener(r103);
        r102.g(new a(this));
        this.f558474b = r102.c();
    }
}
