package com.bytedance.ug.sdk.luckycat.impl.launcher;

import android.content.Intent;
import androidx.fragment.app.Fragment;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\n\u0010\u000bJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¨\u0006\r"}, d2 = {"Lcom/bytedance/ug/sdk/luckycat/impl/launcher/LuckyCatEmptyFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/content/Intent;", "intent", "", "requestCode", "Lmj7/a;", "callback", "", "startActivityForResult", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "luckycat_container_release"}, k = 1, mv = {1, 4, 0})
public final class LuckyCatEmptyFragment extends Fragment {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<Integer, mj7.a> f271144d;

    public static final class a {
    }

    static {
    }

    @Override // androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
    }

    public LuckyCatEmptyFragment() {
        this.f271144d = new LinkedHashMap();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int r100, int r101, Intent r102) {
        super.onActivityResult(r100, r101, r102);
        Map<Integer, mj7.a> r103 = this.f271144d;
        LinkedHashMap r104 = (LinkedHashMap) r103;
        mj7.a r105 = (mj7.a) r104.get(Integer.valueOf(r100));
        if (r105 == null) goto L6;
        r105.onActivityResult();
        return;
    }

    public final void startActivityForResult(Intent r100, int r101, mj7.a r102) {
        this.f271144d.put(Integer.valueOf(r101), r102);
        startActivityForResult(r100, r101);
    }
}
