package com.ss.android.lark.contact.base.contact_mobile_invite.invite;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;
import com.ss.android.lark.contact.base.contact_search.s;
import com.ss.android.lark.contact.base.entity.mobile.ContactMobileBean;
import com.ss.android.lark.contact.base.entity.mobile.item.ItemViewHolder;
import com.ss.android.lark.contact.base.service.c0;
import com.ss.android.lark.contact.base.statistics.InvHitPoint;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a extends b9b.a<a> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static String f418663k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static String f418664l;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ContactMobileBean f418665e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f418666f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f418667g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ImageView f418668h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f418669i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public s f418670j;

    /* JADX INFO: renamed from: com.ss.android.lark.contact.base.contact_mobile_invite.invite.a$a, reason: collision with other inner class name */
    public static final class C4921a {
        public static List a(List r100) {
            Intrinsics.checkNotNullParameter(r100, "beans");
            if (r100.isEmpty() == true) goto L5;
            List r101 = r100;
            ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
            Iterator r103 = r101.iterator();
        L8:
            if (r103.hasNext() == false) goto L10;
            r102.add(new a((ContactMobileBean) r103.next()));
            goto L8
        L10:
            return r102;
        L5:
            return CollectionsKt.listOf(new a());
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f418671a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f418672b;

        public b(a r100, View r101) {
            this.f418671a = r100;
            this.f418672b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            if (this.f418671a.f418666f == false) goto L5;
            return;
        L5:
            Statistics.sendEvent("addressbook_usinglark_invite_click", InvHitPoint.a());
            String r101 = a.f418663k;
            if (r101 != null) goto L10;
            Intrinsics.throwUninitializedPropertyAccessException("inviteMsg");
            r101 = null;
        L10:
            if (TextUtils.isEmpty(r101) == false) goto L12;
            a r102 = this.f418671a;
            Context r103 = this.f418672b.getContext();
            r102.getClass();
            int r104 = c0.f418914a;
            c0.a.a(r103, new com.ss.android.lark.contact.base.contact_mobile_invite.invite.b(r102, r103));
            return;
        L12:
            a.c(this.f418671a, this.f418672b.getContext());
        }
    }

    static {
    }

    public final void d() {
        TextView r100 = null;
        if (this.f418666f == false) goto L15;
        TextView r101 = this.f418667g;
        if (r101 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("actionTv");
        r101 = null;
    L7:
        r101.setBackgroundColor(0);
        TextView r102 = this.f418667g;
        if (r102 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("actionTv");
        r102 = null;
    L10:
        r102.setTextColor(UIHelper.getColor(R.color.text_placeholder));
        TextView r103 = this.f418667g;
        if (r103 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("actionTv");
    L14:
        r100.setText(R.string.Lark_NewContacts_MobileContactsInviteToLarkInvited);
        return;
    L13:
        r100 = r103;
        goto L14
    L15:
        TextView r104 = this.f418667g;
        if (r104 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("actionTv");
        r104 = null;
    L18:
        r104.setBackgroundResource(R.drawable.inv_invite_btn_bg_enable);
        TextView r105 = this.f418667g;
        if (r105 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("actionTv");
        r105 = null;
    L21:
        r105.setTextColor(UIHelper.getColor(R.color.static_white));
        TextView r106 = this.f418667g;
        if (r106 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("actionTv");
    L25:
        r100.setText(R.string.Lark_NewContacts_MobileContactsInviteToLarkButton);
        return;
    L24:
        r100 = r106;
        goto L25
    }

    public a() {
        super(R.layout.inv_invite_external_contact_v2_empty_view);
    }

    public a(ContactMobileBean r100) {
        Intrinsics.checkNotNullParameter(r100, "bean");
        super(R.layout.inv_invite_external_contact_v2_invite_item_view);
        this.f418665e = r100;
    }

    @Override // b9b.a
    public final void b(ItemViewHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        this.f18372a = false;
        if (this.f418668h != null) goto L5;
        return;
    L5:
        if (this.f418669i == null) goto L12;
        ContactMobileBean r101 = this.f418665e;
        if (r101 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("bean");
        r101 = null;
    L9:
        r101.cancelLoadAvatar(this.f418669i, this.f418668h);
        return;
    }

    public static final void c(final a r100, final Context r101) {
        r100.getClass();
        ContactMobileBean r102 = r100.f418665e;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("bean");
        r102 = null;
    L5:
        String r103 = r102.getEmailOrPhoneE164();
        String r104 = f418663k;
        if (r104 == null) goto L8;
        String r105 = r104;
    L9:
        s r106 = new s(r101, r103, r105, new InviteExternalContactInviteItem$showDrawer$1(r101, r100), c.f418675a);
        r106.j();
        r100.f418670j = r106;
        return;
    L8:
        Intrinsics.throwUninitializedPropertyAccessException("inviteMsg");
        r105 = null;
        goto L9
    }

    @Override // b9b.a
    public final void a(ItemViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        int r102 = 0;
        if (this.f18373b != (a.class.hashCode() + R.layout.inv_invite_external_contact_v2_empty_view)) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L8;
        return;
    L8:
        View r104 = r100.itemView;
        this.f418667g = (TextView) r100.T3(R.id.ieciiActionTv);
        this.f418668h = (ImageView) r100.T3(R.id.ieciiAvatarIv);
        this.f418669i = (TextView) r100.T3(R.id.ieciiAvatarTv);
        TextView r105 = (TextView) r100.T3(R.id.ieciiUsernameTv);
        TextView r106 = (TextView) r100.T3(R.id.ieciiCpTv);
        ViewGroup.LayoutParams r107 = r104.getLayoutParams();
        Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        RecyclerView.LayoutParams r108 = (RecyclerView.LayoutParams) r107;
        if (r101 != 0) goto L11;
        r102 = UIHelper.dp2px(8.0f);
    L11:
        ((ViewGroup.MarginLayoutParams) r108).topMargin = r102;
        r104.setLayoutParams(r108);
        ContactMobileBean r109 = this.f418665e;
        ContactMobileBean r110 = null;
        if (r109 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("bean");
        r109 = null;
    L14:
        r109.loadAvatar(this.f418669i, this.f418668h);
        ContactMobileBean r111 = this.f418665e;
        if (r111 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("bean");
        r111 = null;
    L17:
        r105.setText(r111.getName());
        ContactMobileBean r112 = this.f418665e;
        if (r112 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("bean");
    L21:
        r106.setText(r110.getEmailOrPhone());
        d();
        q.a(r104);
        r104.setOnClickListener(new b(this, r104));
        return;
    L20:
        r110 = r112;
        goto L21
    L5:
        r103 = false;
        goto L6
    }
}
