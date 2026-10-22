package com.ss.android.lark.contact.customized.externalcontact.data;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.lark.pb.contact.v2.ContactProfile;
import com.bytedance.lark.pb.contact.v2.GetContactsDoubaoResponse;
import com.bytedance.lark.pb.contact.v2.GetContactsScene;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.biz.im.api.h0;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.contact.customized.common.OfficeContactUtils;
import com.ss.android.lark.contact.customized.externalcontact.repository.OfficeExternalContactRepository;
import com.ss.android.lark.contact.customized.externalcontact.repository.e;
import com.ss.android.lark.contact.customized.externalcontact.repository.j;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.sdk.f;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes35.dex */
public final class PersonalContactsLoader extends BaseContactsLoader {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f419114j = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MutableLiveData<i9b.a<List<mtb.d>>> f419115e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<Long, mtb.d> f419116f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f419117g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final d f419118h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c f419119i;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PersonalContactsLoader f419120a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List<mtb.d> f419121b;

        public b(PersonalContactsLoader r100, List<mtb.d> r101) {
            this.f419120a = r100;
            this.f419121b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f419120a.f419115e.setValue(new i9b.a.c(this.f419121b));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements h0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PersonalContactsLoader f419122a;

        public c(PersonalContactsLoader r100) {
            this.f419122a = r100;
        }

        @Override // com.ss.android.lark.biz.im.api.h0
        public final void a(Chatter r100) {
            if (r100 != null) goto L4;
            return;
        L4:
            PersonalContactsLoader r101 = this.f419122a;
            Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
            PersonalContactsLoader.g(r101, r100);     // Catch: Throwable -> L7
            Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            Result.Companion r103 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
        }
    }

    public static final class d implements com.ss.android.lark.contact.customized.externalcontact.repository.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PersonalContactsLoader f419123a;

        public d(PersonalContactsLoader r100) {
            this.f419123a = r100;
        }

        @Override // com.ss.android.lark.contact.customized.externalcontact.repository.b
        public final void a(mtb.d r110) {
            Intrinsics.checkNotNullParameter(r110, "contact");
            PersonalContactsLoader r100 = this.f419123a;
            i9b.a<List<mtb.d>> r101 = r100.f419115e.getValue();
            if ((r101 instanceof i9b.a.c) == false) goto L5;
            i9b.a.c r102 = (i9b.a.c) r101;
        L6:
            if (r102 == null) goto L11;
            List r103 = (List) r102.f488829a;
            if (r103 == null) goto L11;
            List<mtb.d> r104 = CollectionsKt.toMutableList(r103);
            if (r104 == null) goto L11;
        L12:
            long r105 = r110.f515662a;
            Iterator<mtb.d> r106 = r104.iterator();
            int r107 = 0;
        L14:
            if (r106.hasNext() == false) goto L22;
            if (r106.next().f515662a != r105) goto L18;
            boolean r108 = true;
        L19:
            if (r108 == true) goto L23;
            r107 = r107 + 1;
        L23:
            Log.i("Contact_PersonalLoader", "update contact=" + r110.f515671j + " and idx=" + r107);
            if (r110.f515671j == false) goto L27;
            if (r107 < 0) goto L34;
            ListProtector.remove(r104, r107);
            r100.h(r104, false);
            return;
        L34:
            return;
        L27:
            if (r107 < 0) goto L29;
            ListProtector.set(r104, r107, r110);
        L30:
            r100.h(r104, true);
            return;
        L29:
            r104.add(r110);
            goto L30
        L18:
            r108 = false;
            goto L19
        L22:
            r107 = -1;
        L11:
            r104 = new ArrayList();
            goto L12
        L5:
            r102 = null;
            goto L6
        }
    }

    static {
    }

    @Override // com.ss.android.lark.contact.customized.externalcontact.data.BaseContactsLoader
    public final void b() {
        Log.i("Contact_PersonalLoader", "fetchData");
        ((HashMap) this.f419116f).clear();
        this.f419115e.setValue(i9b.a.b.f488828a);
        long r100 = System.currentTimeMillis();
        long r101 = ((KVRepo) ((DoubaoContactSyncStateStore) this.f419107c.getValue()).f419110b.getValue()).getLong("last_full_sync_time_millis", 0);
        if (r101 > 0) goto L6;
        Log.i("Contact_BaseLoader", "no cache, ttl=" + ((Number) this.f419108d.getValue()).longValue());
        boolean r102 = true;
    L10:
        if (r102 == false) goto L12;
        Log.i("Contact_PersonalLoader", "startFullColdSync");
        i(GetContactsScene.GET_CONTACTS_SCENE_FULL_COLD, true);
        return;
    L12:
        Log.i("Contact_PersonalLoader", "startIncrShortSync");
        i(GetContactsScene.GET_CONTACTS_SCENE_INCR_SHORT, false);
        return;
    L6:
        if ((r100 - r101) < ((Number) this.f419108d.getValue()).longValue()) goto L8;
        r102 = true;
    L9:
        Log.i("Contact_BaseLoader", "isFullSyncExpired last=" + r101 + " now=" + r100 + " ttl=" + ((Number) this.f419108d.getValue()).longValue() + " expired=" + r102);
        goto L10
    L8:
        r102 = false;
        goto L9
    }

    @Override // com.ss.android.lark.contact.customized.externalcontact.data.BaseContactsLoader
    public final void c() {
        Log.i("Contact_PersonalLoader", "init");
        Lazy r100 = OfficeExternalContactRepository.f419134a;
        d r101 = this.f419118h;
        Intrinsics.checkNotNullParameter(r101, "listener");
        f.a((List) OfficeExternalContactRepository.f419135b.getValue(), r101, e.f419139a);
    }

    @Override // com.ss.android.lark.contact.customized.externalcontact.data.BaseContactsLoader
    public final void e() {
        Log.i("Contact_PersonalLoader", "onCleared");
        if (this.f419117g == false) goto L5;
        ImSdkService.c().te(this.f419119i);
        this.f419117g = false;
    L5:
        Lazy r100 = OfficeExternalContactRepository.f419134a;
        d r101 = this.f419118h;
        Intrinsics.checkNotNullParameter(r101, "listener");
        f.b((List) OfficeExternalContactRepository.f419135b.getValue(), r101, j.f419146a);
    }

    @Override // com.ss.android.lark.contact.customized.externalcontact.data.BaseContactsLoader
    public final void a(final long r100) {
        int r101 = com.ss.android.lark.contact.base.service.d.f418917a;
        String r102 = String.valueOf(r100);
        IGetDataCallback<Boolean> r103 = new PersonalContactsLoader$deleteExternalContact$1(this, r100);
        Intrinsics.checkNotNullParameter(r102, "userId");
        Intrinsics.checkNotNullParameter(r103, "callback");
        ImSdkService.d().N7(r102, r103);
    }

    public static final void g(PersonalContactsLoader r100, Chatter r101) {
        r100.getClass();
        Long r102 = StringsKt.toLongOrNull(r101.getId());
        if (r102 == null) goto L19;
        long r103 = r102.longValue();
        Map<Long, mtb.d> r104 = r100.f419116f;
        HashMap r105 = (HashMap) r104;
        mtb.d r106 = (mtb.d) r105.get(Long.valueOf(r103));
        if (r106 == null) goto L20;
        String r107 = r101.getAvatarKey();
        String r108 = r101.getName();
        String r109 = r101.getAlias();
        if (Intrinsics.areEqual(r106.f515668g, r107) == true) goto L10;
    L14:
        boolean r110 = false;
    L15:
        if (r110 == true) goto L21;
        BuildersKt.launch$default(r100.f419105a, Dispatchers.getIO(), null, new PersonalContactsLoader$onChatterPushed$1(r100, null), 2, null);
        return;
    L21:
        return;
    L10:
        if (Intrinsics.areEqual(r106.f515664c, r108) == false) goto L14;
        if (Intrinsics.areEqual(r106.f515665d, r109) == false) goto L14;
        r110 = true;
        goto L15
    L20:
        return;
    }

    public final void h(List<mtb.d> r100, boolean r101) {
        if (r101 == false) goto L4;
        r100 = CollectionsKt.toMutableList(r100);
        Lazy r102 = OfficeContactUtils.f418960a;
        Intrinsics.checkNotNullParameter(r100, "contactList");
        CollectionsKt.sortWith(r100, com.ss.android.lark.contact.customized.common.d.f418967a);
    L4:
        ((HashMap) this.f419116f).clear();
        Iterator<T> r103 = r100.iterator();
    L6:
        if (r103.hasNext() == false) goto L8;
        mtb.d r104 = (mtb.d) r103.next();
        Map<Long, mtb.d> r105 = this.f419116f;
        HashMap r106 = (HashMap) r105;
        r106.put(Long.valueOf(r104.f515662a), r104);
        goto L6
    L8:
        UICallbackExecutor.execute(new b(this, r100));
    }

    public final void i(GetContactsScene r210, boolean r211) {
        Ref.IntRef r100 = new Ref.IntRef();
        BuildersKt.launch$default(this.f419105a, Dispatchers.getIO(), null, new PersonalContactsLoader$startLocalAndServer$1(this, r210, r100, null), 2, null);
        BuildersKt.launch$default(this.f419105a, Dispatchers.getIO(), null, new PersonalContactsLoader$startLocalAndServer$2(this, r210, r100, r211, null), 2, null);
    }

    public PersonalContactsLoader(CoroutineScope r100, MutableLiveData<i9b.a<List<mtb.d>>> r101, Function3<? super Boolean, ? super Boolean, ? super ErrorResult, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        Intrinsics.checkNotNullParameter(r101, "contactsLiveData");
        Intrinsics.checkNotNullParameter(r102, "reportPerf");
        super(r100, r102);
        this.f419115e = r101;
        this.f419116f = new HashMap();
        this.f419118h = new d(this);
        this.f419119i = new c(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.util.ArrayList] */
    public static final Pair f(PersonalContactsLoader r100, boolean r101, GetContactsScene r102) {
        r100.getClass();
        SdkSender.d r103 = OfficeExternalContactRepository.a(r101, r102);
        GetContactsDoubaoResponse r104 = (GetContactsDoubaoResponse) r103.f439867a;
        if (r104 == null) goto L15;
        List<ContactProfile> r105 = r104.contacts;
        if (r105 == null) goto L11;
        List<ContactProfile> r106 = r105;
        Object r107 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r106, 10));
        Iterator<T> r108 = r106.iterator();
    L9:
        if (r108.hasNext() == false) goto L13;
        ContactProfile r109 = (ContactProfile) r108.next();
        int r110 = mtb.d.f515661l;
        Intrinsics.checkNotNull(r109);
        r107.add(mtb.d.a.a(r109));
    L13:
        return TuplesKt.to(r107, null);
    L11:
        r107 = CollectionsKt.emptyList();
        goto L13
    L15:
        return TuplesKt.to(null, r103.f439868b);
    }
}
