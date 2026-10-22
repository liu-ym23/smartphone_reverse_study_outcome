package com.obric.assistant.activity_stack;

import android.app.Activity;
import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\b\u001a\u00020\tH&J1\u0010\u0007\u001a\u0004\u0018\u0001H\n\"\b\b\u0000\u0010\n*\u00020\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\f2\b\b\u0002\u0010\b\u001a\u00020\tH&¢\u0006\u0002\u0010\rJ\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\b\u001a\u00020\tH&J\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¨\u0006\u0012"}, d2 = {"Lcom/obric/assistant/activity_stack/IObricActivityStackService;", "", "init", "", "getActivityList", "", "Landroid/app/Activity;", "getLastStartedActivity", "requireStarted", "", ExifInterface.GPS_DIRECTION_TRUE, "activityClass", "Ljava/lang/Class;", "(Ljava/lang/Class;Z)Landroid/app/Activity;", "getLastStartedDefaultChatActivity", "sortActivitiesByStartTime", "activityList", "getActivityListSortByStartTime", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricActivityStackService {
    Activity a(Class r100);

    List<Activity> b();

    Activity c();

    void init();
}
