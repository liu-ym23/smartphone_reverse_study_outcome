package com.ss.android.lark.contact.customized.externalcontact.data;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.contact.v1.GetSubordinateDepartmentsRequest;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.contact.customized.department.d;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sdk.SdkSender;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import mtb.i;
import mtb.m;

/* JADX INFO: loaded from: classes35.dex */
public final class EnterpriseContactsLoader extends BaseContactsLoader {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f419111g = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MutableLiveData<i9b.a<List<m>>> f419112e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<? extends m> f419113f;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.contact.customized.externalcontact.data.BaseContactsLoader
    public final void d() {
    }

    @Override // com.ss.android.lark.contact.customized.externalcontact.data.BaseContactsLoader
    public final void b() {
        Log.i("Contact_EnterpriseLoader", "fetchData");
        this.f419113f = CollectionsKt.emptyList();
        this.f419112e.setValue(i9b.a.b.f488828a);
        int r100 = d.f419102a;
        IGetDataCallback<List<? extends i>> r101 = new EnterpriseContactsLoader$fetchData$1(this);
        Intrinsics.checkNotNullParameter(r101, "callback");
        GetSubordinateDepartmentsRequest.Builder r102 = new GetSubordinateDepartmentsRequest.Builder();
        SdkSender.asynSendRequestNonWrap(Command.GET_SUBORDINATE_DEPARTMENTS, r102, r101, com.ss.android.lark.contact.customized.department.a.f419099a);
    }

    @Override // com.ss.android.lark.contact.customized.externalcontact.data.BaseContactsLoader
    public final void c() {
        Log.i("Contact_EnterpriseLoader", "init");
    }

    @Override // com.ss.android.lark.contact.customized.externalcontact.data.BaseContactsLoader
    public final void e() {
        Log.i("Contact_EnterpriseLoader", "onCleared");
    }

    public EnterpriseContactsLoader(CoroutineScope r100, MutableLiveData<i9b.a<List<m>>> r101, Function3<? super Boolean, ? super Boolean, ? super ErrorResult, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        Intrinsics.checkNotNullParameter(r101, "contactsLiveData");
        Intrinsics.checkNotNullParameter(r102, "reportPerf");
        super(r100, r102);
        this.f419112e = r101;
        this.f419113f = CollectionsKt.emptyList();
    }
}
