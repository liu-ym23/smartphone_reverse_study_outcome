package com.ss.android.ugc.aweme.search.mob.base;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.ss.android.ugc.aweme.search.mob.BaseMetricsEvent;
import com.ss.android.ugc.aweme.search.mob.base.BaseMobEvent;
import com.ss.android.ugc.aweme.search.utils.GsonUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0016\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00002\u00020\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/ss/android/ugc/aweme/search/mob/base/BaseMobEvent;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/ss/android/ugc/aweme/search/mob/BaseMetricsEvent;", "", "Companion", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class BaseMobEvent<T extends BaseMobEvent<T>> extends BaseMetricsEvent {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap<String, String> f453322d;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0015\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/ss/android/ugc/aweme/search/mob/base/BaseMobEvent$Companion;", "", "()V", "ANCHOR_ID", "", "AUTHOR_ID", "CID", "CLUE_IS_BIZ_ACCOUNT", "COLUMN_TYPE", "ENTER_FROM", "ENTER_GROUP_ID", "ENTITY_PATHS", "GROUP_ID", "HISTORY_SUG", "IS_FREE_CHARGE", "IS_JOINT_ROOM", "JOINT_ANCHOR_ID", "LINK_USER_ID", "MUSIC_ID", "PHOTO_NUM", "PREVIOUS_PAGE", "REQUEST_ID", "ROOM_ID", "VIDEO_SOURCE", "VIDEO_TAG", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    static {
        new Companion(0);
    }

    @Override // com.ss.android.ugc.aweme.search.mob.BaseMetricsEvent
    public void c() {
    }

    public BaseMobEvent(String r100) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        super(r100);
        this.f453322d = new HashMap();
    }

    public final void g(Map r100) {
        if (r100 == null) goto L11;
        Iterator r101 = r100.entrySet().iterator();
    L5:
        if (r101.hasNext() == false) goto L19;
        Map.Entry r102 = (Map.Entry) r101.next();
        Object r103 = r102.getValue();
        if (r103 == null) goto L5;
        String r104 = r103.toString();
        if (r104 == null) goto L5;
        f((String) r102.getKey(), r104);
        goto L5
    L19:
        return;
    }

    public final void h(String r100) {
        if (r100 == null) goto L5;
        String r101 = this.f453322d.put(a.KEY_ENTER_GROUP_ID, r100);
        return;
    }

    public static void e(BaseMobEvent r100, Map r101) {
        if (r101 == null) goto L13;
        Iterator r102 = r101.entrySet().iterator();
    L6:
        if (r102.hasNext() == false) goto L22;
        Map.Entry r103 = (Map.Entry) r102.next();
        if (r100.f453322d.containsKey(r103.getKey()) == true) goto L6;
        Object r104 = r103.getValue();
        if ((r104 instanceof String) == true) goto L11;
        r100.f((String) r103.getKey(), GsonProtectorUtils.toJson(GsonUtil.a(), r104));
        goto L6
    L11:
        r100.f((String) r103.getKey(), (String) r104);
        goto L6
    L22:
        return;
    }

    public final void d(Map r100, boolean r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        Iterator r102 = r100.entrySet().iterator();
    L6:
        if (r102.hasNext() == false) goto L22;
        Map.Entry r103 = (Map.Entry) r102.next();
        if (r101 == true) goto L16;
        HashMap<String, String> r104 = this.f453322d;
        Object r105 = r103.getKey();
        if (r104 == null) goto L15;
        if (r104.containsKey(r105) == true) goto L6;
    L15:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
    L16:
        Object r106 = r103.getValue();
        if ((r103.getKey() instanceof String) == false) goto L6;
        if ((r106 instanceof String) == true) goto L20;
        f(String.valueOf(r103.getKey()), GsonProtectorUtils.toJson(GsonUtil.a(), r106));
        goto L6
    L20:
        f(String.valueOf(r103.getKey()), (String) r106);
        goto L6
    }

    public final void f(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L12;
        this.f453322d.put(r100, r101);
        return;
    L12:
        return;
    L5:
        if (r101.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    @Override // com.ss.android.ugc.aweme.search.mob.BaseMetricsEvent, com.ss.android.ugc.aweme.search.mob.MetricsEvent
    public void post(PageFinder r100, String r101) {
        this.f453276a.putAll(this.f453322d);
        if (this.f453276a.containsKey("entity_paths") == false) goto L5;
        this.f453276a.remove("entity_paths");
    L5:
        super.post(r100, r101);
    }
}
