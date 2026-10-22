package com.ss.android.lark.location.service;

import android.content.Context;
import com.bytedance.supervisor.token.Token;
import com.ss.android.lark.location.dto.LarkLocation;
import com.ss.android.lark.location.dto.Scene;
import com.ss.android.lark.location.listener.LocationRequestOption;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes36.dex */
public interface g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f431202a = 0;

    public interface a {
        void a(LarkLocation r100);
    }

    boolean getLocation(Context r100, Token r101, Scene r102, a r103);

    d getLocationMessageMap();

    ILocationServiceType getLocationServiceType();

    boolean getLocationWithOption(Context r100, LocationRequestOption r101, Token r102, Scene r103, a r104);

    h getPOIService();

    IPickLocationMap getPickLocationMap();

    boolean isAdminGpsEnabled();

    boolean isAdminLocationMapSDKEnabled();

    boolean isGmsEnabled();

    boolean isInHouse(double r100, double r101);

    static {
        new ConcurrentHashMap();
    }
}
