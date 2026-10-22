package com.bytedance.ee.bear.middleground.permission.apply;

import android.app.Application;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.bytedance.ee.bear.common.DisplayName;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.google.gson.Gson;
import com.larus.nova.R;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.util.LinkedHashMap;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 02\u00020\u0001:\u0003012B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020$J\u000e\u0010*\u001a\u00020+2\u0006\u0010\u0012\u001a\u00020\rJ\u0016\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-2\b\u0010/\u001a\u0004\u0018\u00010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u0017X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0019\"\u0004\b \u0010!R\u001b\u0010%\u001a\u00020&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u0011\u001a\u0004\b'\u0010(¨\u00063"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/apply/PermApplyViewModel;", "Landroidx/lifecycle/ViewModel;", "params", "Lcom/bytedance/ee/bear/middleground/permission/apply/NoPermission;", "<init>", "(Lcom/bytedance/ee/bear/middleground/permission/apply/NoPermission;)V", "getParams", "()Lcom/bytedance/ee/bear/middleground/permission/apply/NoPermission;", "appContext", "Landroid/app/Application;", "kotlin.jvm.PlatformType", "_permType", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/ee/bear/middleground/permission/apply/PermApplyViewModel$PermType;", "get_permType", "()Landroidx/lifecycle/MutableLiveData;", "_permType$delegate", "Lkotlin/Lazy;", "permType", "Landroidx/lifecycle/LiveData;", "getPermType", "()Landroidx/lifecycle/LiveData;", "tipsText", "", "getTipsText", "()Ljava/lang/String;", "ownerText", "Landroid/text/Spanned;", "getOwnerText", "()Landroid/text/Spanned;", "ownerStr", "getOwnerStr", "setOwnerStr", "(Ljava/lang/String;)V", "getDisplayName", "account", "Lcom/bytedance/ee/bear/contract/AccountService$Account;", "applyDocPermPuller", "Lcom/bytedance/ee/bear/middleground/permission/apply/ApplyDocPermPuller;", "getApplyDocPermPuller", "()Lcom/bytedance/ee/bear/middleground/permission/apply/ApplyDocPermPuller;", "applyDocPermPuller$delegate", "setPermType", "", "requestPerm", "Lio/reactivex/Flowable;", "", "msg", "Companion", "Factory", "PermType", "middleground-permission-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PermApplyViewModel extends ViewModel {
    public static final a Companion = null;
    public static final String TAG = "PermApplyViewModel";
    private final Lazy _permType$delegate;
    private final Application appContext;
    private final Lazy applyDocPermPuller$delegate;
    public String ownerStr;
    private final Spanned ownerText;
    private final NoPermission params;
    private final String tipsText;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\n\u001a\u00020\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/apply/PermApplyViewModel$PermType;", "", "code", "", "<init>", "(Ljava/lang/String;II)V", "getCode", "()I", "READ", "EDIT", "getText", "", "middleground-permission-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum PermType extends Enum<PermType> {
        public static final PermType EDIT = null;
        public static final PermType READ = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ PermType[] f232970a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f232971b = null;
        private final int code;

        public static EnumEntries<PermType> getEntries() {
            return f232971b;
        }

        static {
            PermType r100 = new PermType("READ", 0, 1);
            READ = r100;
            PermType r101 = new PermType("EDIT", 1, 4);
            EDIT = r101;
            PermType[] r102 = {r100, r101};
            f232970a = r102;
            f232971b = EnumEntriesKt.enumEntries(r102);
        }

        public static PermType[] values() {
            return (PermType[]) f232970a.clone();
        }

        public final String getText() {
            int r100 = this.code;
            if (r100 == 1) goto L9;
            if (r100 == 4) goto L11;
            return "";
        L11:
            return eu5.b.f474075a.getString(R.string.Doc_Facade_EditPermission);
        L9:
            return eu5.b.f474075a.getString(R.string.Doc_Facade_ReadPermission);
        }

        public final int getCode() {
            return this.code;
        }

        public static PermType valueOf(String r100) {
            return (PermType) r27.a.a(PermType.class, r100);
        }

        public PermType(String r100, int r101, int r102) {
            super(r100, r101);
            this.code = r102;
        }
    }

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static PermApplyViewModel a(Fragment r100, NoPermission r101) {
            Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
            Intrinsics.checkNotNullParameter(r101, "params");
            return (PermApplyViewModel) ViewModelProviders.of(r100, new b(r101)).get(PermApplyViewModel.class);
        }
    }

    public static final class b implements ViewModelProvider.Factory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final NoPermission f232972a;

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public final /* synthetic */ ViewModel create(Class r100, CreationExtras r101) {
            return ViewModelProvider.Factory.CC.$default$create(this, r100, r101);
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public final /* synthetic */ ViewModel create(KClass r100, CreationExtras r101) {
            return ViewModelProvider.Factory.CC.$default$create(this, r100, r101);
        }

        public b(NoPermission r100) {
            Intrinsics.checkNotNullParameter(r100, "params");
            this.f232972a = r100;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public final <T extends ViewModel> T create(Class<T> r100) {
            Intrinsics.checkNotNullParameter(r100, "modelClass");
            return r100.getConstructor(new Class[]{NoPermission.class}).newInstance(new Object[]{this.f232972a});
        }
    }

    public static final class c<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c<T, R> f232973a = null;

        static {
            f232973a = new c();
        }

        public c() {
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            Intrinsics.checkNotNullParameter((ApplyDocPermPuller.Result) r100, "it");
            return Boolean.TRUE;
        }
    }

    static {
        Companion = new a();
    }

    @JvmStatic
    public static final PermApplyViewModel get(Fragment r100, NoPermission r101) {
        Companion.getClass();
        return a.a(r100, r101);
    }

    private final ApplyDocPermPuller getApplyDocPermPuller() {
        return (ApplyDocPermPuller) this.applyDocPermPuller$delegate.getValue();
    }

    private final MutableLiveData<PermType> get_permType() {
        return (MutableLiveData) this._permType$delegate.getValue();
    }

    public final String getOwnerStr() {
        String r100 = this.ownerStr;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("ownerStr");
        return null;
    }

    public final LiveData<PermType> getPermType() {
        return get_permType();
    }

    public final Spanned getOwnerText() {
        return this.ownerText;
    }

    public final NoPermission getParams() {
        return this.params;
    }

    public final String getTipsText() {
        return this.tipsText;
    }

    public PermApplyViewModel(NoPermission r110) {
        Intrinsics.checkNotNullParameter(r110, "params");
        this.params = r110;
        Application r100 = eu5.b.f474075a;
        this.appContext = r100;
        this._permType$delegate = LazyKt.lazy(PermApplyViewModel$_permType$2.INSTANCE);
        this.tipsText = r100.getString(R.string.Doc_Permission_OwnerNotAuthorizeCross);
        AccountService$Account r101 = ((com.bytedance.ee.bear.contract.h0) org.koin.java.a.c(com.bytedance.ee.bear.contract.h0.class, null, null, 6)).G2();
        if (r101 == null) goto L34;
        LinkedHashMap r102 = new LinkedHashMap();
        String r103 = ou5.a.d(((com.bytedance.ee.bear.contract.i0) org.koin.java.a.c(com.bytedance.ee.bear.contract.i0.class, null, null, 6)).a(), getDisplayName(r101), r101.userName, r101.enName);
        if (r101.isConsumer() == false) goto L7;
        String r104 = r100.getString(R.string.Doc_Permission_PersonalAccount);
    L8:
        String r105 = r110.getOwnerName();
        Pattern r106 = yu5.c.f569228a;
    L30:
        th = move-exception;
        tt5.a.d("StringUtils", "tryGetStringWithoutTwoSpace fails：" + th);
    L32:
        this.appContext.getString(R.string.Doc_Permission_Owner);
        r102.put("user", b0.a(r104 + '-' + r103));
        r102.put("owner", String.format("<font color=%s>%s</font>", new Object[]{String.valueOf(eu5.b.f474075a.getResources().getColor(R.color.primary_fill_default)), b0.a(r105)}));
        setOwnerStr(r105);
        Unit r107 = Unit.INSTANCE;
        Spanned r108 = Html.fromHtml(xo5.a.d(r100, R.string.Doc_Permission_CurrentUserCannotAccessApply, r102));
        if (r108 == null) goto L34;
    L35:
        this.ownerText = r108;
        this.applyDocPermPuller$delegate = LazyKt.lazy(PermApplyViewModel$applyDocPermPuller$2.INSTANCE);
        return;
    L10:
        if (TextUtils.isEmpty(r105) == true) goto L32;
        r105 = r105.trim();     // Catch: Throwable -> L30
        String[] r111 = r105.split(" ");     // Catch: Throwable -> L30
        StringBuffer r112 = new StringBuffer();     // Catch: Throwable -> L30
        if (r111 == null) goto L15;
    L17:
        int r113 = r111.length;     // Catch: Throwable -> L30
        int r114 = 0;
        boolean r115 = false;
    L18:
        if (r114 >= r113) goto L28;
        String r116 = r111[r114];     // Catch: Throwable -> L30
        if ("".equals(r116) == false) goto L24;
        if (r115 == true) goto L27;
        r112.append(" ");     // Catch: Throwable -> L30
        r115 = true;
    L27:
        r114 = r114 + 1;     // Catch: Throwable -> L30
        goto L18
    L24:
        if (r115 == true) goto L26;
        r112.append(" ");     // Catch: Throwable -> L30
    L26:
        r112.append(r116);     // Catch: Throwable -> L30
        r115 = false;
        goto L27
    L28:
        r105 = r112.toString().trim();     // Catch: Throwable -> L30
        goto L32
    L15:
        if (r111.length > 0) goto L17;
    L7:
        r104 = r101.tenantName;
    L34:
        r108 = new SpannableString("");
        goto L35
    }

    public final String getDisplayName(AccountService$Account r100) {
        Intrinsics.checkNotNullParameter(r100, "account");
        DisplayName r101 = new DisplayName();
        r101.setValue(r100.displayName);
        String r102 = new Gson().toJson(r101);     // Catch: Throwable -> L5
    L6:
        Intrinsics.checkNotNull(r102);
        return r102;
    L5:
        r102 = r100.displayName;
        tt5.a.d(TAG, "displayname Error");
        goto L6
    }

    public final Flowable<Boolean> requestPerm(String r100) {
        ApplyDocPermPuller r101 = getApplyDocPermPuller();
        String r102 = this.params.getToken();
        String r103 = this.params.getDocumentType();
        String r104 = "";
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        PermType r105 = get_permType().getValue();
        if (r105 == null) goto L12;
        String r106 = Integer.valueOf(r105.getCode()).toString();
        if (r106 == null) goto L12;
        r104 = r106;
    L12:
        return r101.a(new ApplyDocPermPuller.Params(r102, r103, r100, r104)).map(c.f232973a);
    }

    public final void setOwnerStr(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.ownerStr = r100;
    }

    public final void setPermType(PermType r100) {
        Intrinsics.checkNotNullParameter(r100, "permType");
        get_permType().setValue(r100);
    }
}
