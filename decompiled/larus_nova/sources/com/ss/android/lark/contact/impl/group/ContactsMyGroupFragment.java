package com.ss.android.lark.contact.impl.group;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.account.platform.api.IVKService;
import com.larus.nova.R;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.contact.base.statistics.ContactHitPoint;
import com.ss.android.lark.statistics.Statistics;
import fsb.f;
import kotlin.Lazy;
import org.json.JSONObject;
import q9b.d;

/* JADX INFO: loaded from: classes35.dex */
public class ContactsMyGroupFragment extends BaseFragment {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f419462i = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f419463d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.ss.android.lark.contact.impl.group.b f419464e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f419465f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public d f419466g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a f419467h;

    public class a implements ContactsMyGroupView.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ContactsMyGroupFragment f419468a;

        public a(ContactsMyGroupFragment r100) {
            this.f419468a = r100;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Message f419469a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Chat f419470b;

        public b(Message r100) {
            this.f419469a = r100;
        }
    }

    public ContactsMyGroupFragment() {
        this.f419463d = false;
        this.f419467h = new a(this);
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.f419464e.destroy();
    }

    @Override // com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final void onAttach(Context r100) {
        super.onAttach(r100);
        if (getArguments() == null) goto L8;
        this.f419463d = getArguments().getBoolean("IS_FROM_CONTACT_TAB", false);
        Message r101 = (Message) getArguments().getParcelable("SELECT_GROUP_MSG");
        if (r101 == null) goto L9;
        b r102 = new b(r101);
        this.f419466g = new d(this, r102);
        getLifecycle().addObserver(new com.ss.android.lark.contact.impl.group.a(r102));
        return;
    L9:
        return;
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        super.onViewCreated(r100, r101);
        if (getActivity() == null) goto L11;
        String r102 = getActivity().getIntent().getStringExtra("APPRECIABLE_KEY_CONTACTS_MY_GROUP");
        String r103 = r9b.a.f536742a;
        if (r102 == null) goto L8;
        r9b.a.f536742a = r102;
    L8:
        if (this.f419463d == false) goto L12;
        Lazy r104 = ContactHitPoint.f418947a;
        Statistics.sendEvent("contact_groups_category_click", new JSONObject().put("location", IVKService.ResponseConstants.CREATED));
        return;
    L12:
        return;
    }

    @Override // com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        this.f419465f = r100.inflate(R.layout.activity_contacts_my_group, r101, false);
        f.b().h("onCreateView");
        f.b().i("initMVP");
        com.ss.android.lark.contact.impl.group.b r103 = new com.ss.android.lark.contact.impl.group.b(getActivity(), this.f419467h, this.f419466g, getChildFragmentManager());
        this.f419464e = r103;
        r103.create();
        Lazy r104 = ContactHitPoint.f418947a;
        Statistics.sendEvent("contact_groups_view");
        JSONObject r105 = new JSONObject();
        r105.put("member_type", ContactHitPoint.a());
        Statistics.sendEvent("contact_group_view", r105);
        f.b().h("initMVP");
        return this.f419465f;
    }
}
