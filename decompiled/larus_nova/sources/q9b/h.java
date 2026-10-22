package q9b;

import android.view.View;
import com.larus.nova.R;
import com.ss.android.lark.contact.base.dependency.ContactBaseModuleDependency;
import com.ss.android.lark.contact.impl.group.ContactsMyGroupView;
import com.ss.android.lark.ui.IActionTitlebar$TextAction;

/* JADX INFO: loaded from: classes35.dex */
public final class h extends IActionTitlebar$TextAction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ContactsMyGroupView f532192a;

    @Override // com.ss.android.lark.ui.IActionTitlebar$BaseAction, com.ss.android.lark.ui.IActionTitlebar$Action
    public final void performAction(View r100) {
        super.performAction(r100);
        ContactBaseModuleDependency.f418857b.openCreateGroupChat(this.f532192a.f419471a);
    }

    public h(ContactsMyGroupView r100, String r101) {
        this.f532192a = r100;
        super(r101, R.color.text_link_normal);
    }
}
