package com.bytedance.ee.bear.document.member;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\nJ\u0006\u0010\u000f\u001a\u00020\rJ\u0006\u0010\u0010\u001a\u00020\rR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0019\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/document/member/DocumentMemberViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "active", "Landroidx/lifecycle/MutableLiveData;", "", "getActive", "()Landroidx/lifecycle/MutableLiveData;", "memberListData", "Lcom/bytedance/ee/bear/document/member/MemberListData;", "getMemberListData", "showMemberList", "", "data", "closeMemberList", BasicTestActionHandler.TEST_ACTION_RESET, "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocumentMemberViewModel extends ViewModel {
    public static final a Companion = null;
    private static final String TAG = "DocumentMemberViewModel";
    private final MutableLiveData<Boolean> active;
    private final MutableLiveData<MemberListData> memberListData;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final void closeMemberList() {
        this.active.setValue(Boolean.FALSE);
    }

    public final void reset() {
        this.memberListData.setValue(null);
    }

    public DocumentMemberViewModel() {
        this.active = new MutableLiveData();
        this.memberListData = new MutableLiveData();
    }

    public final MutableLiveData<Boolean> getActive() {
        return this.active;
    }

    public final MutableLiveData<MemberListData> getMemberListData() {
        return this.memberListData;
    }

    public final void showMemberList(MemberListData r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        if (r100.checkValid() == false) goto L6;
        this.active.setValue(Boolean.TRUE);
        this.memberListData.setValue(r100);
        return;
    }
}
