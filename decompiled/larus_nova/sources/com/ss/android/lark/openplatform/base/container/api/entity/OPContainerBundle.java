package com.ss.android.lark.openplatform.base.container.api.entity;

import android.content.Context;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.opmonitor.trace.OPTrace;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public class OPContainerBundle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public OPTrace f437583a;

    public static final enum API_TYPE extends Enum<API_TYPE> {
        public static final API_TYPE INVOKE = null;
        public static final API_TYPE ON = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ API_TYPE[] f437584a = null;
        private final String type;

        static {
            API_TYPE r100 = new API_TYPE("INVOKE", 0, AbsMethodDelegate.TAG_INVOKE);
            INVOKE = r100;
            API_TYPE r101 = new API_TYPE("ON", 1, "on");
            ON = r101;
            f437584a = new API_TYPE[]{r100, r101};
        }

        public static API_TYPE[] values() {
            return (API_TYPE[]) f437584a.clone();
        }

        public String getType() {
            return this.type;
        }

        public static API_TYPE valueOf(String r100) {
            return (API_TYPE) a.a(API_TYPE.class, r100);
        }

        public API_TYPE(String r100, int r101, String r102) {
            super(r100, r101);
            this.type = r102;
        }
    }

    public Context getContext() {
        return null;
    }
}
