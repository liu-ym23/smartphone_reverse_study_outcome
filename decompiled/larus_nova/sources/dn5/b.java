package dn5;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.onboarding.OnBoardingData;
import com.bytedance.ee.bear.document.orientation.BaseSensorOrientationDetectorPlugin;
import com.bytedance.ee.bear.document.orientation.BaseUnspecifiedOrientationPlugin;
import com.bytedance.ee.docsdk.impl.base.DocumentType;

/* JADX INFO: loaded from: classes18.dex */
public abstract class b extends com.bytedance.ee.bear.document.onboarding.b implements tk5.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f469320c;

    @Override // tk5.d
    public final String getBiz() {
        return DocumentType.SHEET_NAME;
    }

    @Override // com.bytedance.ee.bear.document.onboarding.b, tk5.d
    public final String getDependency() {
        return null;
    }

    @Override // tk5.a
    public final String a() {
        OnBoardingData r100 = this.f220703a;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.nextID;
    }

    public final boolean d() {
        DocumentPluginHost r100 = this.f220704b;
        BaseUnspecifiedOrientationPlugin r101 = (BaseUnspecifiedOrientationPlugin) r100.findPlugin(BaseUnspecifiedOrientationPlugin.class);
        BaseSensorOrientationDetectorPlugin r102 = (BaseSensorOrientationDetectorPlugin) r100.findPlugin(BaseSensorOrientationDetectorPlugin.class);
        if (r101 == null) goto L6;
        if (r102 == null) goto L6;
        r102.getOrientation().observe(this.f220704b.getLifecycleOwner(), new a(this));
    L6:
        FragmentActivity r103 = this.f220704b.getActivity();
        if (r103 != null) goto L9;
    L11:
        boolean r104 = false;
    L12:
        if (r104 == false) goto L14;
        return true;
    L14:
        if (this.f469320c == true) goto L19;
        return false;
    L19:
        return true;
    L9:
        if (r103.getResources().getConfiguration().orientation != 2) goto L11;
        r104 = true;
        goto L12
    }

    public b() {
    }
}
