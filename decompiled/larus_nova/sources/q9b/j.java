package q9b;

import androidx.viewpager.widget.ViewPager;
import com.bytedance.sdk.account.platform.api.IVKService;
import com.ss.android.lark.contact.base.statistics.ContactHitPoint;
import com.ss.android.lark.statistics.Statistics;
import kotlin.Lazy;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes35.dex */
public final class j implements ViewPager.OnPageChangeListener {
    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public final void onPageScrollStateChanged(int r100) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public final void onPageScrolled(int r100, float r101, int r102) {
    }

    public j() {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public final void onPageSelected(int r100) {
        if (r100 != 0) goto L6;
        Lazy r101 = ContactHitPoint.f418947a;
        Statistics.sendEvent("contact_groups_category_click", new JSONObject().put("location", IVKService.ResponseConstants.CREATED));
        return;
    L6:
        if (r100 != 1) goto L10;
        Lazy r102 = ContactHitPoint.f418947a;
        Statistics.sendEvent("contact_groups_category_click", new JSONObject().put("location", "joined"));
        return;
    }
}
