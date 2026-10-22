package com.ss.android.ugc.bytex.pthread.base.convergence.hook;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0001H\u0016¨\u0006\t"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/hook/ExtraProvider;", "", "getExtra", "key", "", "removeExtra", "setExtra", "", "value", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
public interface ExtraProvider {

    /* JADX INFO: loaded from: classes40.dex */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 13})
    public static final class DefaultImpls {
        public static Object getExtra(ExtraProvider r100, String r101) {
            return null;
        }

        public static Object removeExtra(ExtraProvider r100, String r101) {
            return null;
        }

        public static void setExtra(ExtraProvider r100, String r101, Object r102) {
        }
    }

    Object getExtra(String r100);

    Object removeExtra(String r100);

    void setExtra(String r100, Object r101);
}
