package com.ss.android.lark.api.api;

import androidx.fragment.app.Fragment;
import com.ss.android.lark.api.bean.ForsetiChainType;
import com.ss.android.lark.api.bean.config.a;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/api/api/ForsetiBaseChainFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "chainType", "Lcom/ss/android/lark/api/bean/ForsetiChainType;", "getChainType", "()Lcom/ss/android/lark/api/bean/ForsetiChainType;", "chainConfig", "Lcom/ss/android/lark/api/bean/config/ForsetiChainConfig;", "getChainConfig", "()Lcom/ss/android/lark/api/bean/config/ForsetiChainConfig;", "latestChainConfig", "getLatestChainConfig", "forseti-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class ForsetiBaseChainFragment extends Fragment {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ForsetiChainType f408643d;

    public ForsetiBaseChainFragment() {
        this.f408643d = ForsetiChainType.TYPE_NORMAL;
        int r100 = a.f408666g;
        a.C4743a.a();
        a.C4743a.a();
    }

    public ForsetiChainType S90() {
        return this.f408643d;
    }
}
