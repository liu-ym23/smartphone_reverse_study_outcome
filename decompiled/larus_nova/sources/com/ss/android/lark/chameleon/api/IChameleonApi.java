package com.ss.android.lark.chameleon.api;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.ss.android.lark.chameleon.idependency.IDependency;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH&J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH&J.\u0010\u000f\u001a\u00020\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH&J\u0012\u0010\u0010\u001a\u00020\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/chameleon/api/IChameleonApi;", "", "getChameleonFragment", "Landroidx/fragment/app/Fragment;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "chameleonConfig", "Lcom/ss/android/lark/chameleon/api/ChameleonConfig;", "bizPlugins", "", "Lcom/ss/android/lark/chameleon/api/AbsChameleonPlugin;", "init", "", "iDependency", "Lcom/ss/android/lark/chameleon/idependency/IDependency;", "open", "preloadWebview", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface IChameleonApi {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Fragment getChameleonFragment$default(IChameleonApi r100, Context r101, ChameleonConfig r102, List r103, int r104, Object r105) {
            if (r105 != null) goto L9;
            if ((r104 & 4) == 0) goto L7;
            r103 = null;
        L7:
            return r100.getChameleonFragment(r101, r102, r103);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getChameleonFragment");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void open$default(IChameleonApi r100, Context r101, ChameleonConfig r102, List r103, int r104, Object r105) {
            if (r105 != null) goto L9;
            if ((r104 & 4) == 0) goto L6;
            r103 = null;
        L6:
            r100.open(r101, r102, r103);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: open");
        }
    }

    Fragment getChameleonFragment(Context r100, ChameleonConfig r101, List<? extends AbsChameleonPlugin> r102);

    void init(IDependency r100);

    void open(Context r100, ChameleonConfig r101, List<? extends AbsChameleonPlugin> r102);

    void preloadWebview(ChameleonConfig r100);
}
