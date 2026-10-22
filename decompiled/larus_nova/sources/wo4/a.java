package wo4;

import com.bytedance.ee.bear.bitable.common.model.field.EFieldType;

/* JADX INFO: loaded from: classes15.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f560518a = 0;

    /* JADX INFO: renamed from: wo4.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C8140a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f560519a = null;

        static {
            int[] r100 = new int[EFieldType.values().length];
            r100[EFieldType.STAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[EFieldType.DATE_TIME.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f560519a = r100;
        }
    }

    static {
    }
}
