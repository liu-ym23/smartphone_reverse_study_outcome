package com.bytedance.ee.bear.document.telephoneability;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import c45.a;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\bR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/document/telephoneability/TelephoneAbilityViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "sendMessageAction", "Landroidx/lifecycle/MutableLiveData;", "", "getSendMessageAction", "()Landroidx/lifecycle/MutableLiveData;", "callTelephoneAction", "getCallTelephoneAction", "searchContractAction", "Lcom/bytedance/ee/bear/document/telephoneability/TelephoneContractItemModel;", "getSearchContractAction", "searchContractResult", "getSearchContractResult", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TelephoneAbilityViewModel extends ViewModel {
    private final MutableLiveData<String> callTelephoneAction;
    private final MutableLiveData<a> searchContractAction;
    private final MutableLiveData<a> searchContractResult;
    private final MutableLiveData<String> sendMessageAction;

    public TelephoneAbilityViewModel() {
        this.sendMessageAction = new MutableLiveData();
        this.callTelephoneAction = new MutableLiveData();
        this.searchContractAction = new MutableLiveData();
        this.searchContractResult = new MutableLiveData();
    }

    public final MutableLiveData<String> getCallTelephoneAction() {
        return this.callTelephoneAction;
    }

    public final MutableLiveData<a> getSearchContractAction() {
        return this.searchContractAction;
    }

    public final MutableLiveData<a> getSearchContractResult() {
        return this.searchContractResult;
    }

    public final MutableLiveData<String> getSendMessageAction() {
        return this.sendMessageAction;
    }
}
