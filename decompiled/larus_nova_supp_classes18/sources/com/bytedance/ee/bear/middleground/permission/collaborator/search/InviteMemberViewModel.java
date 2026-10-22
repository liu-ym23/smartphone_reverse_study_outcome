package com.bytedance.ee.bear.middleground.permission.collaborator.search;

import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.middleground_permission_export.model.permissionset.DocPermSetInfo;
import com.bytedance.ee.bear.share.export.UserInfo;
import dh5.b;
import dh5.c;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0007H\u0016J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0007H\u0016J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\nH\u0016J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\nH\u0016J\u0012\u0010\u0015\u001a\u00020\u000f2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\fH\u0016J\u0006\u0010\u0017\u001a\u00020\u000fR\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\n0\u0006j\b\u0012\u0004\u0012\u00020\n`\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/collaborator/search/InviteMemberViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/bytedance/ee/bear/middleground/permission/collaborator/search/newsearch/ISelectedUserModel;", "<init>", "()V", "selectedUsers", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/share/export/UserInfo;", "Lkotlin/collections/ArrayList;", "selectedUserChangeListeners", "Lcom/bytedance/ee/bear/middleground/permission/collaborator/search/newsearch/SelectedUserChangeListener;", "docPermSetInfo", "Lcom/bytedance/ee/bear/middleground_permission_export/model/permissionset/DocPermSetInfo;", "getSelected", "addUser", "", "userInfo", "removeUser", "registerChangeListener", "listener", "unregisterChangeListener", "setDocPermSetInfo", "getDocPermSetInfo", "clearDataAndListener", "middleground-permission-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InviteMemberViewModel extends ViewModel implements b {
    private DocPermSetInfo docPermSetInfo;
    private final ArrayList<c> selectedUserChangeListeners;
    private final ArrayList<UserInfo> selectedUsers;

    public final void clearDataAndListener() {
        this.selectedUserChangeListeners.clear();
        this.selectedUsers.clear();
    }

    public InviteMemberViewModel() {
        this.selectedUsers = new ArrayList();
        this.selectedUserChangeListeners = new ArrayList();
    }

    public DocPermSetInfo getDocPermSetInfo() {
        return this.docPermSetInfo;
    }

    @Override // dh5.b
    public ArrayList<UserInfo> getSelected() {
        return this.selectedUsers;
    }

    @Override // dh5.b
    public void addUser(UserInfo r3) {
        Intrinsics.checkNotNullParameter(r3, "userInfo");
        if (this.selectedUsers.contains(r3) == true) goto L8;
        this.selectedUsers.add(r3);
        Iterator<c> r0 = this.selectedUserChangeListeners.iterator();
    L6:
        if (r0.hasNext() == false) goto L10;
        r0.next().g8(r3);
        goto L6
    L10:
        return;
    }

    @Override // dh5.b
    public void registerChangeListener(c r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        if (this.selectedUserChangeListeners.contains(r2) == true) goto L6;
        this.selectedUserChangeListeners.add(r2);
        return;
    }

    @Override // dh5.b
    public void removeUser(UserInfo r3) {
        Intrinsics.checkNotNullParameter(r3, "userInfo");
        if (this.selectedUsers.contains(r3) == false) goto L8;
        this.selectedUsers.remove(r3);
        Iterator<c> r0 = this.selectedUserChangeListeners.iterator();
    L6:
        if (r0.hasNext() == false) goto L10;
        r0.next().W1(r3);
        goto L6
    L10:
        return;
    }

    public void setDocPermSetInfo(DocPermSetInfo r1) {
        this.docPermSetInfo = r1;
    }

    @Override // dh5.b
    public void unregisterChangeListener(c r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        if (this.selectedUserChangeListeners.contains(r2) == false) goto L6;
        this.selectedUserChangeListeners.remove(r2);
        return;
    }
}
