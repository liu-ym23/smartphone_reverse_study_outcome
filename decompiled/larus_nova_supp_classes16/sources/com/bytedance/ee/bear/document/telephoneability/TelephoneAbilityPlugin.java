package com.bytedance.ee.bear.document.telephoneability;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.supervisor.token.Token;
import com.suite.lark.emm.impl.clipboard.utils.TextViewMenuUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001e2\u00020\u00012\u00020\u0002:\u0001\u001eB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0017\u001a\u00020\u000eH\u0002J\"\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ee/bear/document/telephoneability/TelephoneAbilityPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPlugin;", "Lcom/bytedance/ee/bear/facade/common/ActivityResultHandler;", "<init>", "()V", "telephoneAbilityViewModel", "Lcom/bytedance/ee/bear/document/telephoneability/TelephoneAbilityViewModel;", "getTelephoneAbilityViewModel", "()Lcom/bytedance/ee/bear/document/telephoneability/TelephoneAbilityViewModel;", "setTelephoneAbilityViewModel", "(Lcom/bytedance/ee/bear/document/telephoneability/TelephoneAbilityViewModel;)V", "currentHexString", "", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/document/DocumentPluginHost;", "onDetachFromHost", "sendMessageObserver", "Landroidx/lifecycle/Observer;", "callTelephoneObserver", "searchContractObserver", "Lcom/bytedance/ee/bear/document/telephoneability/TelephoneContractItemModel;", "openSystemContract", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TelephoneAbilityPlugin extends DocumentPlugin implements sa5.a {
    public static final a Companion = null;
    public static final String OPEN_CONTACTS_WARNING = "OPEN_CONTACTS_WARNING";
    public static final int REQUEST_CONTRACT_INFO_CODE = 10010;
    public static final String TAG = "TelephoneAbilityPlugin";
    public static final String TOKEN = "LARK-PSDA-bitable_phone_cell_pick_contacts_phone_number";
    private final Observer<String> callTelephoneObserver;
    private volatile String currentHexString;
    private final Observer<c45.a> searchContractObserver;
    private final Observer<String> sendMessageObserver;
    public TelephoneAbilityViewModel telephoneAbilityViewModel;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ TelephoneAbilityPlugin a;

        public b(TelephoneAbilityPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            String r5 = (String) r4;
            Intrinsics.checkNotNullParameter(r5, "it");
            Intent r0 = new Intent("android.intent.action.DIAL");
            r0.setData(UriProtector.parse("tel:" + r5));
            TextViewMenuUtilsKt.a(r0);
            TelephoneAbilityPlugin.access$getContext(this.a).startActivity(r0);
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ TelephoneAbilityPlugin a;

        public c(TelephoneAbilityPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            c45.a r3 = (c45.a) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            TelephoneAbilityPlugin.access$setCurrentHexString$p(this.a, r3.a);
            TelephoneAbilityPlugin.access$openSystemContract(this.a);
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ TelephoneAbilityPlugin a;

        public d(TelephoneAbilityPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            String r5 = (String) r4;
            Intrinsics.checkNotNullParameter(r5, "it");
            TelephoneAbilityPlugin.access$getContext(this.a).startActivity(new Intent("android.intent.action.SENDTO", UriProtector.parse("smsto:" + r5)));
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void openSystemContract() {
        Intent r0 = new Intent("android.intent.action.PICK");
        r0.setType("vnd.android.cursor.dir/phone_v2");
        ((DocumentPluginHost) getHost()).c().startActivityForResult(r0, REQUEST_CONTRACT_INFO_CODE);
    }

    public final TelephoneAbilityViewModel getTelephoneAbilityViewModel() {
        TelephoneAbilityViewModel r0 = this.telephoneAbilityViewModel;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("telephoneAbilityViewModel");
        return null;
    }

    public TelephoneAbilityPlugin() {
        this.sendMessageObserver = new d(this);
        this.callTelephoneObserver = new b(this);
        this.searchContractObserver = new c(this);
    }

    public static final /* synthetic */ Context access$getContext(TelephoneAbilityPlugin r0) {
        return r0.getContext();
    }

    public static final /* synthetic */ void access$openSystemContract(TelephoneAbilityPlugin r0) {
        r0.openSystemContract();
    }

    public void onAttachToHost(DocumentPluginHost r3) {
        super.onAttachToHost(r3);
        setTelephoneAbilityViewModel((TelephoneAbilityViewModel) viewModel(TelephoneAbilityViewModel.class));
        getTelephoneAbilityViewModel().getSendMessageAction().observe(getLifecycleOwner(), this.sendMessageObserver);
        getTelephoneAbilityViewModel().getCallTelephoneAction().observe(getLifecycleOwner(), this.callTelephoneObserver);
        getTelephoneAbilityViewModel().getSearchContractAction().observe(getLifecycleOwner(), this.searchContractObserver);
    }

    public void onDetachFromHost(DocumentPluginHost r2) {
        super.onDetachFromHost(r2);
        getTelephoneAbilityViewModel().getSendMessageAction().removeObserver(this.sendMessageObserver);
        getTelephoneAbilityViewModel().getCallTelephoneAction().removeObserver(this.callTelephoneObserver);
        getTelephoneAbilityViewModel().getSearchContractAction().removeObserver(this.searchContractObserver);
    }

    public final void setTelephoneAbilityViewModel(TelephoneAbilityViewModel r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.telephoneAbilityViewModel = r2;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DocumentPluginHost) r1);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((DocumentPluginHost) r1);
    }

    public static final /* synthetic */ void access$setCurrentHexString$p(TelephoneAbilityPlugin r0, String r1) {
        r0.currentHexString = r1;
    }

    @Override // sa5.a
    public void onActivityResult(int r12, int r13, Intent r14) {
        if (r14 != null) goto L5;
    L34:
        tt5.a.h(TAG, "getPhoneBySystemContract: onSelectCancel");
        return;
    L5:
        if (TextUtils.isEmpty(this.currentHexString) == true) goto L34;
        if (r12 != 10010) goto L34;
        ContentResolver r3 = getContext().getContentResolver();     // Catch: Throwable -> L22 Exception -> L24
        sf7.a r2 = sf7.a.a;     // Catch: Throwable -> L22 Exception -> L24
        Intrinsics.checkNotNull(r3);     // Catch: Throwable -> L22 Exception -> L24
        Uri r4 = r14.getData();     // Catch: Throwable -> L22 Exception -> L24
        Intrinsics.checkNotNull(r4);     // Catch: Throwable -> L22 Exception -> L24
        Cursor r16 = r2.query(r3, r4, null, null, null, null, new Token(TOKEN));     // Catch: Throwable -> L22 Exception -> L24
        if (r16 != null) goto L36;
    L19:
        if (r16 == null) goto L41;
        r16.close();
        return;
    L41:
        return;
    L36:
    L17:
        Exception e = e;
    L26:
        tt5.a.d(TAG, "onActivityResult error:" + e);     // Catch: Throwable -> L30
        if (r16 == null) goto L42;
    L16:
        r16.close();
        return;
    L42:
        return;
    L30:
        Throwable th = th;
    L31:
        if (r16 == null) goto L33;
        r16.close();
    L33:
        throw th;
    L13:
        if (r16.moveToFirst() == false) goto L19;
        String r1 = r16.getString(r16.getColumnIndex("data1"));     // Catch: Exception -> L17 Throwable -> L30
        MutableLiveData<c45.a> r5 = getTelephoneAbilityViewModel().getSearchContractResult();     // Catch: Exception -> L17 Throwable -> L30
        c45.a r6 = new c45.a();     // Catch: Exception -> L17 Throwable -> L30
        r6.a = this.currentHexString;     // Catch: Exception -> L17 Throwable -> L30
        r6.b = r1;     // Catch: Exception -> L17 Throwable -> L30
        r5.postValue(r6);     // Catch: Exception -> L17 Throwable -> L30
        this.currentHexString = null;     // Catch: Exception -> L17 Throwable -> L30
        goto L16
    L24:
        e = move-exception;
        r16 = null;
        e = e;
    L22:
        th = move-exception;
        r16 = null;
        th = th;
        goto L31
    }
}
