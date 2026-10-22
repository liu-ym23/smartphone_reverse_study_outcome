package rgb;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.larksuite.framework.utils.ICUUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.flow.chat.view.sheet.FlowBottomSheet;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a extends FlowBottomSheet {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f537741d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c f537742e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public C7480a f537743f;

    /* JADX INFO: renamed from: rgb.a$a, reason: collision with other inner class name */
    public static final class C7480a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Chat f537744a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f537745b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C7480a) == true) goto L8;
            return false;
        L8:
            C7480a r101 = (C7480a) r100;
            if (Intrinsics.areEqual(this.f537744a, r101.f537744a) == true) goto L12;
            return false;
        L12:
            if (this.f537745b == r101.f537745b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f537744a.hashCode() * 31;
            if (this.f537745b == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "Data(chat=" + this.f537744a + ", isExpired=" + this.f537745b + ')';
        }

        public C7480a(Chat r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "chat");
            this.f537744a = r100;
            this.f537745b = r101;
        }
    }

    public interface b {
        void v(Chat r100);
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f537746a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ImageView f537747b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TextView f537748c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final TextView f537749d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final TextView f537750e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final View f537751f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final ImageView f537752g;

        public c(View r100) {
            Intrinsics.checkNotNullParameter(r100, "rootView");
            this.f537746a = r100;
            this.f537747b = (ImageView) r100.findViewById(R.id.group_avatar);
            this.f537748c = (TextView) r100.findViewById(R.id.group_name);
            this.f537749d = (TextView) r100.findViewById(R.id.group_desc);
            this.f537750e = (TextView) r100.findViewById(R.id.group_join_bt);
            this.f537751f = r100.findViewById(R.id.close_bt);
            this.f537752g = (ImageView) r100.findViewById(R.id.invalid_status_icon);
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f537753a;

        public d(a r100) {
            this.f537753a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f537753a.b(true);
        }
    }

    public static final class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f537754a;

        public e(a r100) {
            this.f537754a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f537754a.b(true);
        }
    }

    public static final class f implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f537755a;

        public f(a r100) {
            this.f537755a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f537755a.b(true);
        }
    }

    public static final class g implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f537756a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Chat f537757b;

        public g(a r100, Chat r101) {
            this.f537756a = r100;
            this.f537757b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f537756a.f537741d.v(this.f537757b);
        }
    }

    public final void e() {
        c r100 = this.f537742e;
        if (r100 != null) goto L5;
        return;
    L5:
        C7480a r101 = this.f537743f;
        if (r101 != null) goto L8;
        return;
    L8:
        Chat r102 = r101.f537744a;
        com.ss.android.lark.chat.utils.g.e(r100.f537746a.getContext(), r100.f537747b, r102.getAvatarKey(), r102.getEntityId(), UIHelper.dp2px(56.0f), UIHelper.dp2px(56.0f), Scene.Chat);
        r100.f537751f.setOnClickListener(new d(this));
        Context r103 = r100.f537746a.getContext();
        if (r101.f537744a.isDissolved() == false) goto L12;
        r100.f537748c.setText(UIUtils.getString(r103, R.string.LarkIM_Group_CodeDisbanded_Title));
        r100.f537749d.setVisibility(8);
        r100.f537752g.setVisibility(0);
        r100.f537750e.setText(UIUtils.getString(r103, R.string.LarkIM_Common_GotIt_Button));
        r100.f537750e.setTextColor(UIUtils.getColor(r100.f537746a.getContext(), R.color.flow_ud_neutral_100));
        r100.f537750e.setBackgroundResource(R.drawable.flow_bg_group_card_join_bt_expired);
        r100.f537750e.setOnClickListener(new e(this));
        return;
    L12:
        if (r101.f537745b == false) goto L14;
        r100.f537748c.setText(UIUtils.getString(r103, R.string.LarkIM_Group_InviteExpired_Title));
        r100.f537749d.setVisibility(8);
        r100.f537752g.setVisibility(0);
        r100.f537750e.setText(UIUtils.getString(r103, R.string.LarkIM_Common_GotIt_Button));
        r100.f537750e.setTextColor(UIUtils.getColor(r100.f537746a.getContext(), R.color.flow_ud_neutral_100));
        r100.f537750e.setBackgroundResource(R.drawable.flow_bg_group_card_join_bt_expired);
        r100.f537750e.setOnClickListener(new f(this));
        return;
    L14:
        r100.f537752g.setVisibility(8);
        r100.f537748c.setText(r102.getName());
        r100.f537749d.setVisibility(0);
        int r104 = r102.getMemberCount();
        r100.f537749d.setText(ICUUtils.icuFormat(UIUtils.getQuantityString(r103, R.plurals.LarkIM_Group_GroupMemberNum_Title, r104), "num", Long.valueOf(r104)));
        r100.f537750e.setText(UIUtils.getString(r103, R.string.LarkIM_Group_Invite_Join_Button));
        r100.f537750e.setTextColor(UIUtils.getColor(r100.f537746a.getContext(), R.color.flow_ud_static_white));
        r100.f537750e.setBackgroundResource(R.drawable.flow_bg_group_card_join_bt);
        r100.f537750e.setOnClickListener(new g(this, r102));
    }

    @Override // com.ss.android.lark.flow.chat.view.sheet.FlowBottomSheet
    public final View a(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        View r101 = LayoutInflater.from(r100.getContext()).inflate(R.layout.flow_share_group_card_onboarding_sheet, r100, false);
        Intrinsics.checkNotNull(r101);
        this.f537742e = new c(r101);
        e();
        return r101;
    }

    public a(Activity r100, b r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "listener");
        super(r100);
        this.f537741d = r101;
    }
}
