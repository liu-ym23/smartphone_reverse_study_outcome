package p7a;

import java.util.Map;

/* JADX INFO: loaded from: classes32.dex */
public interface a {
    boolean canConsumeGesture(float r100, float r101);

    int getGestureArenaMemberId();

    Map<Integer, s7a.a> getGestureDetectorMap();

    Map<Integer, t7a.a> getGestureHandlers();

    int getMemberScrollX();

    int getMemberScrollY();

    int getScrollContainerDirection();

    int getSign();

    boolean isAtBorder(boolean r100);

    void onGestureScrollBy(float r100, float r101);

    void onInvalidate();

    void onPlatformGestureStatusChanged(int r100);
}
