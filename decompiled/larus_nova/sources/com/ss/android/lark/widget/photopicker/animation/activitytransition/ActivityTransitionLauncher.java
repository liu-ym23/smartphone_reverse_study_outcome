package com.ss.android.lark.widget.photopicker.animation.activitytransition;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import cdc.d;
import com.bytedance.common.utility.DeviceUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.log.Log;
import java.io.Serializable;

/* JADX INFO: loaded from: classes38.dex */
public final class ActivityTransitionLauncher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f447460a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f447461b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int[] f447462c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LocationInfo f447463d;

    public static class LocationInfo implements Serializable {
        public int height;
        public int left;
        public int top;
        public int width;

        public Rect getLocation() {
            int r100 = this.left;
            int r101 = this.top;
            return new Rect(r100, r101, this.width + r100, this.height + r101);
        }

        public LocationInfo() {
        }

        public LocationInfo(Rect r100) {
            this.width = r100.width();
            this.height = r100.height();
            this.left = r100.left;
            this.top = r100.top;
        }

        public LocationInfo(int r100, int r101, int r102, int r103) {
            this.width = r100;
            this.height = r101;
            this.left = r102;
            this.top = r103;
        }
    }

    public final Bundle a() {
        if (this.f447463d != null) goto L10;
        View r100 = this.f447461b;
        if (r100 != null) goto L7;
        Log.w("ActivityTransitionLauncher", "parseLocationInfoFromTargetView / Use screenWidth and screenHeight");
        LocationInfo r101 = new LocationInfo(DeviceUtils.getScreenWidth(this.f447460a), DeviceUtils.getScreenHeight(this.f447460a), 0, 0);
    L8:
        this.f447463d = r101;
        goto L10
    L7:
        LocationInfo r102 = new LocationInfo();
        r102.width = r100.getMeasuredWidth();
        r102.height = r100.getMeasuredHeight();
        int[] r103 = new int[2];
        r100.getLocationOnScreen(r103);
        r102.left = r103[0];
        r102.top = r103[1];
        r101 = r102;
    L10:
        if (this.f447462c != null) goto L12;
        this.f447462c = new int[]{DeviceUtils.getScreenWidth(this.f447460a), 0};
        this.f447462c[1] = DeviceUtils.getScreenHeight(this.f447460a) - UIUtils.dp2px(this.f447460a, 64.0f);
    L12:
        Activity r104 = this.f447460a;
        LocationInfo r105 = this.f447463d;
        int[] r106 = this.f447462c;
        int r107 = r105.width;
        int r108 = r105.height;
        float r109 = r107;
        float r110 = r108;
        float r111 = r109 / r110;
        float r112 = r106[0] / r106[1];
        int[] r113 = new int[2];
        if (r111 <= r112) goto L15;
        int r114 = (int) (r109 / r112);
        r113[0] = r105.left;
        r113[1] = (r105.top + (r108 / 2)) - (r114 / 2);
        int r115 = r114;
        int r116 = r107;
    L17:
        return new d(r104, r113[0], r113[1], r116, r115, null).a();
    L15:
        int r117 = (int) (r110 * r112);
        r113[1] = r105.top;
        r113[0] = (r105.left + (r107 / 2)) - (r117 / 2);
        r116 = r117;
        r115 = r108;
        goto L17
    }

    public ActivityTransitionLauncher(Activity r100) {
        this.f447460a = r100;
    }
}
