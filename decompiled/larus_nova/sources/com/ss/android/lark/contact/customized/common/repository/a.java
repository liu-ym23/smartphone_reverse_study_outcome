package com.ss.android.lark.contact.customized.common.repository;

import com.bytedance.lark.pb.contact.v2.ContactProfile;
import com.bytedance.lark.pb.contact.v2.GetContactsDoubaoResponse;
import com.bytedance.lark.pb.contact.v2.GetContactsScene;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.squareup.wire.ProtoAdapter;
import com.ss.android.lark.contact.customized.common.OfficeContactUtils;
import com.ss.android.lark.contact.customized.externalcontact.repository.OfficeExternalContactRepository;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.contact.api.model.OfficeContactListScene;
import com.ss.android.lark.pb.department.ContactDisplayModule;
import com.ss.android.lark.pb.department.PullDepartmentStructureRequest;
import com.ss.android.lark.pb.department.PullDepartmentStructureResponse;
import com.ss.android.lark.pb.entities.Chatter;
import com.ss.android.lark.pb.entities.Image;
import com.ss.android.lark.pb.entities.ImageSet;
import com.ss.android.lark.pb.improto.Command;
import com.ss.android.lark.picker.doubao.ExternalContactRecommendPageDataPuller;
import com.ss.android.lark.picker.doubao.organization.DoubaoOrganizationPickerView;
import com.ss.android.lark.sdk.SdkSender;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import mtb.d;
import mtb.j;

/* JADX INFO: loaded from: classes35.dex */
public final class a implements ktb.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f418968a = 0;

    /* JADX INFO: renamed from: com.ss.android.lark.contact.customized.common.repository.a$a, reason: collision with other inner class name */
    public static final class C4930a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f418969a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f418970b = null;

        static {
            int[] r100 = new int[OfficeContactListScene.values().length];
            r100[OfficeContactListScene.FULL_COLD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[OfficeContactListScene.INCR_SHORT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L6:
            f418969a = r100;
            int[] r101 = new int[ContactDisplayModule.values().length];
            r101[ContactDisplayModule.DISPLAY_MODULE_DEPARTMENT_LEADER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L25:
            r101[ContactDisplayModule.DISPLAY_MODULE_DEPARTMENT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L21:
            r101[ContactDisplayModule.DISPLAY_MODULE_USER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L10:
            f418970b = r101;
        }
    }

    static {
    }

    public a() {
    }

    @Override // ktb.b
    public final void b(ExternalContactRecommendPageDataPuller.AnonymousClass2 r110) {
        Intrinsics.checkNotNullParameter(r110, "callback");
        Log.i("Contact_OpenRepository", "getContactList preferLocal=false scene=null");
        OfficeContactListScene r100 = OfficeContactListScene.INCR_SHORT;
        int r101 = b.f418969a[r100.ordinal()];
        if (r101 != 1) goto L5;
        GetContactsScene r102 = GetContactsScene.GET_CONTACTS_SCENE_FULL_COLD;
    L10:
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new ContactOpenRepository$getContactList$1(false, this, r102, r110, null), 2, null);
        return;
    L5:
        if (r101 != 2) goto L8;
        r102 = GetContactsScene.GET_CONTACTS_SCENE_INCR_SHORT;
        goto L10
    L8:
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Pair c(a r100, boolean r101, GetContactsScene r102) {
        r100.getClass();
        SdkSender.d r103 = OfficeExternalContactRepository.a(r101, r102);
        if (r103.f439868b == null) goto L9;
        StringBuilder r104 = new StringBuilder("getContactsDoubao error fromLocal=");
        r104.append(r101);
        r104.append(" scene=");
        r104.append(r102);
        r104.append(' ');
        ErrorResult r105 = r103.f439868b;
        if (r105 == null) goto L7;
        String r106 = r105.getMessage();
    L8:
        r104.append(r106);
        Log.i("Contact_OpenRepository", r104.toString());
        goto L9
    L7:
        r106 = null;
    L9:
        GetContactsDoubaoResponse r107 = (GetContactsDoubaoResponse) r103.f439867a;
        if (r107 == null) goto L12;
        List<ContactProfile> r108 = r107.contacts;
    L13:
        List<ContactProfile> r109 = r108;
        if (r109 != null) goto L16;
    L19:
        boolean r110 = true;
    L20:
        if (r110 == false) goto L22;
        Log.i("Contact_OpenRepository", "getContactsDoubao empty fromLocal=" + r101 + " scene=" + r102);
        return new Pair(CollectionsKt.emptyList(), r103.f439868b);
    L22:
        Log.i("Contact_OpenRepository", "getContactsDoubao success fromLocal=" + r101 + " scene=" + r102 + " count=" + r108.size());
        ArrayList r111 = new ArrayList();
        Iterator<T> r112 = r108.iterator();
    L24:
        if (r112.hasNext() == false) goto L26;
        ContactProfile r113 = (ContactProfile) r112.next();
        int r114 = d.f515661l;
        r111.add(d.a.a(r113));
        goto L24
    L26:
        Lazy r115 = OfficeContactUtils.f418960a;
        Intrinsics.checkNotNullParameter(r111, "contactList");
        CollectionsKt.sortWith(r111, com.ss.android.lark.contact.customized.common.d.f418967a);
        return new Pair(r111, null);
    L16:
        if (r109.isEmpty() == true) goto L19;
        r110 = false;
        goto L20
    L12:
        r108 = null;
        goto L13
    }

    public static j d(Chatter r100, Set r110, Set r111) {
        String r101 = r100.mid;
        if (r101 != null) goto L5;
        String r102 = "";
    L6:
        Image r103 = r100.mavatar_image;
        String r104 = null;
        if (r103 == null) goto L9;
        String r105 = r103.mkey;
    L10:
        if (r105 != null) goto L13;
        r105 = "";
    L13:
        if (r105.length() != 0) goto L15;
        boolean r106 = true;
    L16:
        if (r106 == false) goto L23;
        ImageSet r107 = r100.mavatar;
        if (r107 == null) goto L20;
        r104 = r107.mkey;
    L20:
        if (r104 != null) goto L22;
        r104 = "";
    L22:
        String r108 = r104;
    L24:
        String r109 = r100.mname;
        if (r109 != null) goto L27;
        String r112 = "";
    L28:
        boolean r113 = r110.contains(r102);
        boolean r114 = r111.contains(r102);
        Intrinsics.checkNotNullParameter(r112, CommonConstant.KEY_DISPLAY_NAME);
        Intrinsics.checkNotNullParameter(r102, "chatterId");
        Intrinsics.checkNotNullParameter(r108, "avatarKey");
        return new j(r112, r102, r108, r113, r114, CollectionsKt.emptyList());
    L27:
        r112 = r109;
        goto L28
    L23:
        r108 = r105;
        goto L24
    L15:
        r106 = false;
        goto L16
    L9:
        r105 = null;
        goto L10
    L5:
        r102 = r101;
        goto L6
    }

    @Override // ktb.b
    public final void a(final String r110, final int r111, final DoubaoOrganizationPickerView.AnonymousClass1 r112) {
        Intrinsics.checkNotNullParameter(r110, "departmentId");
        Intrinsics.checkNotNullParameter(r112, "callback");
        PullDepartmentStructureRequest.Builder r100 = new PullDepartmentStructureRequest.Builder().department_id(r110).offset(Integer.valueOf(r111)).count(100);
        Boolean r101 = Boolean.TRUE;
        PullDepartmentStructureRequest.Builder r102 = r100.sub_department_paging(r101).use_display_order(r101);
        Command r103 = Command.PULL_DEPARTMENT_STRUCTURE;
        final int r104 = 100;
        IGetDataCallback<PullDepartmentStructureResponse> r105 = new ContactOpenRepository$getDepartmentPage$1(r111, r112, this, r110, r104);
        final ProtoAdapter<PullDepartmentStructureResponse> r113 = PullDepartmentStructureResponse.ADAPTER;
        SdkSender.sendPassThroughRequest(r103, r102, r105, new com.ss.android.lark.contact.customized.common.repository.b(r113));
    }
}
