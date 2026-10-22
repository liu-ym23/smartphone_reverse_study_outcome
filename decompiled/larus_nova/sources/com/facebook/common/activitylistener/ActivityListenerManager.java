package com.facebook.common.activitylistener;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import com.facebook.common.internal.Preconditions;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes22.dex */
public class ActivityListenerManager {

    public static class Listener extends BaseActivityListener {
        private final WeakReference<ActivityListener> mActivityListenerRef;

        public Listener(ActivityListener r100) {
            this.mActivityListenerRef = new WeakReference(r100);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private ActivityListener getListenerOrCleanUp(Activity r100) {
            ActivityListener r101 = this.mActivityListenerRef.get();
            if (r101 != null) goto L5;
            Preconditions.checkArgument(r100 instanceof ListenableActivity);
            ((ListenableActivity) r100).removeActivityListener(this);
        L5:
            return r101;
        }

        @Override // com.facebook.common.activitylistener.BaseActivityListener, com.facebook.common.activitylistener.ActivityListener
        public void onActivityCreate(Activity r100) {
            ActivityListener r101 = getListenerOrCleanUp(r100);
            if (r101 == null) goto L6;
            r101.onActivityCreate(r100);
            return;
        }

        @Override // com.facebook.common.activitylistener.BaseActivityListener, com.facebook.common.activitylistener.ActivityListener
        public void onDestroy(Activity r100) {
            ActivityListener r101 = getListenerOrCleanUp(r100);
            if (r101 == null) goto L6;
            r101.onDestroy(r100);
            return;
        }

        @Override // com.facebook.common.activitylistener.BaseActivityListener, com.facebook.common.activitylistener.ActivityListener
        public void onPause(Activity r100) {
            ActivityListener r101 = getListenerOrCleanUp(r100);
            if (r101 == null) goto L6;
            r101.onPause(r100);
            return;
        }

        @Override // com.facebook.common.activitylistener.BaseActivityListener, com.facebook.common.activitylistener.ActivityListener
        public void onResume(Activity r100) {
            ActivityListener r101 = getListenerOrCleanUp(r100);
            if (r101 == null) goto L6;
            r101.onResume(r100);
            return;
        }

        @Override // com.facebook.common.activitylistener.BaseActivityListener, com.facebook.common.activitylistener.ActivityListener
        public void onStart(Activity r100) {
            ActivityListener r101 = getListenerOrCleanUp(r100);
            if (r101 == null) goto L6;
            r101.onStart(r100);
            return;
        }

        @Override // com.facebook.common.activitylistener.BaseActivityListener, com.facebook.common.activitylistener.ActivityListener
        public void onStop(Activity r100) {
            ActivityListener r101 = getListenerOrCleanUp(r100);
            if (r101 == null) goto L6;
            r101.onStop(r100);
            return;
        }
    }

    public ActivityListenerManager() {
    }

    @Nullable
    public static ListenableActivity getListenableActivity(Context r100) {
        boolean r101 = r100 instanceof ListenableActivity;
        Object r102 = r100;
        if (r101 == true) goto L8;
        boolean r103 = r100 instanceof ContextWrapper;
        r102 = r100;
        if (r103 == false) goto L8;
        r102 = ((ContextWrapper) r100).getBaseContext();
    L8:
        if ((r102 instanceof ListenableActivity) == true) goto L10;
        return null;
    L10:
        return (ListenableActivity) r102;
    }

    public static void register(ActivityListener r100, Context r101) {
        ListenableActivity r102 = getListenableActivity(r101);
        if (r102 == null) goto L6;
        r102.addActivityListener(new Listener(r100));
        return;
    }
}
