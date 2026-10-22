package com.larus.login.impl.switchbind;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import kotlin.Metadata;
import kotlin.Pair;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R%\u0010\u0004\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/larus/login/impl/switchbind/SwitchBindStarterViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "switchBindResult", "Landroidx/lifecycle/MutableLiveData;", "Lkotlin/Pair;", "", "", "getSwitchBindResult", "()Landroidx/lifecycle/MutableLiveData;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SwitchBindStarterViewModel extends ViewModel {
    public static final a Companion = null;
    public static final String TAG = "SwitchBindStarterViewModel";
    private final MutableLiveData<Pair<Boolean, String>> switchBindResult;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public SwitchBindStarterViewModel() {
        this.switchBindResult = new MutableLiveData();
    }

    public final MutableLiveData<Pair<Boolean, String>> getSwitchBindResult() {
        return this.switchBindResult;
    }
}
