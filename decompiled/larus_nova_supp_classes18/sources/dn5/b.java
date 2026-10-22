package dn5;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.onboarding.OnBoardingData;
import com.bytedance.ee.bear.document.orientation.BaseSensorOrientationDetectorPlugin;
import com.bytedance.ee.bear.document.orientation.BaseUnspecifiedOrientationPlugin;
import com.bytedance.ee.docsdk.impl.base.DocumentType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class b extends com.bytedance.ee.bear.document.onboarding.b implements tk5.a {
    public boolean c;

    public final String getBiz() {
        return DocumentType.SHEET_NAME;
    }

    public final String getDependency() {
        return null;
    }

    @Override // tk5.a
    public final String a() {
        OnBoardingData r0 = ((com.bytedance.ee.bear.document.onboarding.b) this).a;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.nextID;
    }

    public final boolean d() {
        DocumentPluginHost r0 = ((com.bytedance.ee.bear.document.onboarding.b) this).b;
        BaseUnspecifiedOrientationPlugin r1 = r0.findPlugin(BaseUnspecifiedOrientationPlugin.class);
        BaseSensorOrientationDetectorPlugin r2 = r0.findPlugin(BaseSensorOrientationDetectorPlugin.class);
        if (r1 == null) goto L6;
        if (r2 == null) goto L6;
        r2.getOrientation().observe(((com.bytedance.ee.bear.document.onboarding.b) this).b.getLifecycleOwner(), new a(this));
    L6:
        FragmentActivity r3 = ((com.bytedance.ee.bear.document.onboarding.b) this).b.getActivity();
        if (r3 != null) goto L9;
    L11:
        boolean r4 = false;
    L12:
        if (r4 == false) goto L14;
        return true;
    L14:
        if (this.c == true) goto L19;
        return false;
    L19:
        return true;
    L9:
        if (r3.getResources().getConfiguration().orientation != 2) goto L11;
        r4 = true;
        goto L12
    }

    public b() {
    }
}
