package com.bytedance.ee.bear.bitable.jsapi.common;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.bitable.jsapi.BitableJSApiErrorCode;
import com.bytedance.supervisor.token.Token;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class PhoneHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f214378a = 0;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0005R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0010\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\n0\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/bear/bitable/jsapi/common/PhoneHelper$PhoneContactsPickerFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "callback", "Lcom/bytedance/ee/bear/bitable/jsapi/common/PhoneHelper$Callback;", "inProgress", "", "pickerLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "pick", "", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class PhoneContactsPickerFragment extends Fragment {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public a f214379d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f214380e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final ActivityResultLauncher<Intent> f214381f;

        public static final class a<O> implements ActivityResultCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ PhoneContactsPickerFragment f214382a;

            public a(PhoneContactsPickerFragment r100) {
                this.f214382a = r100;
            }

            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object r110) {
                ActivityResult r100 = (ActivityResult) r110;
                PhoneContactsPickerFragment r101 = this.f214382a;
                a r102 = r101.f214379d;
                Cursor r103 = null;
                r101.f214379d = null;
                r101.f214380e = false;
                if (r102 != null) goto L6;
                tt5.a.k("FormPhoneHelper", "pickPhoneNumber result ignored: callback is null");
                return;
            L6:
                if (r100.getResultCode() == (-1)) goto L8;
                JSONObject r104 = new JSONObject();
                r104.put2("errCode", Integer.valueOf(BitableJSApiErrorCode.UNKNOWN.getCode()));
                r104.put2("errMsg", "cancel");
                r102.a(r104);
                return;
            L8:
                Intent r105 = r100.getData();
                if (r105 == null) goto L11;
                Uri r111 = r105.getData();
            L12:
                if (r111 != null) goto L45;
                JSONObject r106 = new JSONObject();
                r106.put2("errCode", Integer.valueOf(BitableJSApiErrorCode.UNKNOWN.getCode()));
                r106.put2("errMsg", "empty contact uri");
                r102.b(r106);
                return;
            L45:
                ContentResolver r112 = this.f214382a.requireContext().getContentResolver();     // Catch: Throwable -> L28
                sf7.a r107 = sf7.a.f541727a;     // Catch: Throwable -> L28
                Intrinsics.checkNotNull(r112);     // Catch: Throwable -> L28
                r103 = r107.query(r112, r111, new String[]{"data1"}, null, null, null, new Token("LARK-PSDA-bitable_form_pick_contacts_phone_number"));     // Catch: Throwable -> L28
                if (r103 != null) goto L17;
            L25:
                JSONObject r108 = new JSONObject();     // Catch: Throwable -> L28
                r108.put2("errCode", Integer.valueOf(BitableJSApiErrorCode.UNKNOWN.getCode()));     // Catch: Throwable -> L28
                r108.put2("errMsg", "query contacts failed");     // Catch: Throwable -> L28
                r102.b(r108);     // Catch: Throwable -> L28
                if (r103 == null) goto L53;
            L44:
            L47:
                r103.close();     // Catch: Throwable -> L40
                return;
            L56:
                return;
            L53:
                return;
            L17:
                if (r103.moveToFirst() == false) goto L25;
                String r109 = r103.getString(0);     // Catch: Throwable -> L28
                if (TextUtils.isEmpty(r109) == false) goto L24;
                JSONObject r113 = new JSONObject();     // Catch: Throwable -> L28
                r113.put2("errCode", Integer.valueOf(BitableJSApiErrorCode.UNKNOWN.getCode()));     // Catch: Throwable -> L28
                r113.put2("errMsg", "empty phone number");     // Catch: Throwable -> L28
                r102.b(r113);     // Catch: Throwable -> L28
                goto L44
            L24:
                Intrinsics.checkNotNull(r109);     // Catch: Throwable -> L28
                r102.onSuccess(r109);     // Catch: Throwable -> L28
            L28:
                th = move-exception;
                JSONObject r114 = new JSONObject();     // Catch: Throwable -> L36
                r114.put2("errCode", Integer.valueOf(BitableJSApiErrorCode.UNKNOWN.getCode()));     // Catch: Throwable -> L36
                String r115 = th.getMessage();     // Catch: Throwable -> L36
                if (r115 != null) goto L32;
                r115 = "unknown";
            L32:
                r114.put2("errMsg", r115);     // Catch: Throwable -> L36
                r102.b(r114);     // Catch: Throwable -> L36
                if (r103 != null) goto L47;
                return;
            L36:
                th = move-exception;
                if (r103 != null) goto L42;
            L39:
                throw th;
            L42:
                r103.close();     // Catch: Throwable -> L41
                goto L39
            L11:
                r111 = null;
                goto L12
            }
        }

        public PhoneContactsPickerFragment() {
            this.f214381f = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new a(this));
        }
    }

    public interface a {
        void a(JSONObject r100);

        void b(JSONObject r100);

        void onSuccess(String r100);
    }

    static {
    }

    public static void a(Activity r100, qk5.b r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "callback");
        if ((r100 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r102 = (FragmentActivity) r100;
    L7:
        if (r102 != null) goto L10;
        JSONObject r103 = new JSONObject();
        r103.put2("errCode", Integer.valueOf(BitableJSApiErrorCode.UNKNOWN.getCode()));
        r103.put2("errMsg", "activity is not FragmentActivity");
        r101.b(r103);
        return;
    L10:
        FragmentManager r104 = r102.getSupportFragmentManager();
        Fragment r105 = r104.findFragmentByTag("bitable_phone_contacts_picker");
        if ((r105 instanceof PhoneContactsPickerFragment) == false) goto L13;
        PhoneContactsPickerFragment r106 = (PhoneContactsPickerFragment) r105;
    L15:
        if (r106 != null) goto L21;
        r106 = new PhoneContactsPickerFragment();
        FragmentTransaction r107 = r104.beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r107, r106, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "bitable_phone_contacts_picker", 0) == true) goto L20;
        r107 = r107.add(r106, "bitable_phone_contacts_picker");
    L20:
        r107.commitNowAllowingStateLoss();
    L21:
        Intrinsics.checkNotNullParameter(r101, "callback");
        if (r106.f214380e == false) goto L24;
        JSONObject r108 = new JSONObject();
        r108.put2("errCode", Integer.valueOf(BitableJSApiErrorCode.UNKNOWN.getCode()));
        r108.put2("errMsg", "another pick is in progress");
        r101.b(r108);
        return;
    L24:
        r106.f214380e = true;
        r106.f214379d = r101;
        Intent r109 = new Intent("android.intent.action.PICK");     // Catch: Throwable -> L27 ActivityNotFoundException -> L32
        r109.setType("vnd.android.cursor.dir/phone_v2");     // Catch: Throwable -> L27 ActivityNotFoundException -> L32
        r106.f214381f.launch(r109);     // Catch: Throwable -> L27 ActivityNotFoundException -> L32
    L38:
        return;
    L32:
        r106.f214380e = false;
        r106.f214379d = null;
        JSONObject r110 = new JSONObject();
        r110.put2("errCode", Integer.valueOf(BitableJSApiErrorCode.UNKNOWN.getCode()));
        r110.put2("errMsg", "no contacts app");
        r101.b(r110);
        return;
    L27:
        th = move-exception;
        r106.f214380e = false;
        r106.f214379d = null;
        JSONObject r111 = new JSONObject();
        r111.put2("errCode", Integer.valueOf(BitableJSApiErrorCode.UNKNOWN.getCode()));
        String r112 = th.getMessage();
        if (r112 != null) goto L31;
        r112 = "unknown";
    L31:
        r111.put2("errMsg", r112);
        r101.b(r111);
        return;
    L13:
        r106 = null;
        goto L15
    L5:
        r102 = null;
        goto L7
    }
}
