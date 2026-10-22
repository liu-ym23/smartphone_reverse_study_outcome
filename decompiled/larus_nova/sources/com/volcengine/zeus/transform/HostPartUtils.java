package com.volcengine.zeus.transform;

import androidx.fragment.app.FragmentActivity;

/* JADX INFO: loaded from: classes41.dex */
public class HostPartUtils {
    private Class fragmentActivityClazz;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final HostPartUtils f462915a = null;

        static {
            f462915a = new HostPartUtils();
        }
    }

    public static final Class getFragmentActivityClass() {
        return a.f462915a.fragmentActivityClazz;
    }

    public HostPartUtils() {
        this.fragmentActivityClazz = FragmentActivity.class;     // Catch: Throwable -> L5
        return;
    }

    public static FragmentActivity getFragmentActivity(Object r100, String r101) {
        return (FragmentActivity) ZeusTransformUtils._getActivity(r100, r101);
    }
}
