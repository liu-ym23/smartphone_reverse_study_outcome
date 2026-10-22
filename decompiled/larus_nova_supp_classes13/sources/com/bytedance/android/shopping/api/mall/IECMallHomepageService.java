package com.bytedance.android.shopping.api.mall;

import com.google.gson.JsonObject;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\bg\u0018\u00002\u00020\u0001:\u0004'()*J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0002H&J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH&J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH&J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\fH&J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\fH&J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u000fH&J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u000fH&J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H&J,\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00152\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00010\u0017H&J\u0018\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0015H&J \u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u0015H&J\u0012\u0010\u001f\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u0012H&J\u0012\u0010!\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010\u0012H&J\u0010\u0010$\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\"H&J\n\u0010%\u001a\u0004\u0018\u00010\u0012H&J\n\u0010&\u001a\u0004\u0018\u00010\u0012H&¨\u0006+"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/IECMallHomepageService;", "", "Lcom/bytedance/android/shopping/api/mall/g;", "homepage", "", "setupInstance", "releaseInstance", "getHomepageInstance", "Lcom/bytedance/android/shopping/api/mall/IECMallHomepageService$a;", "listener", "registerDataSetChangeListener", "unregisterDataSetChangeListener", "Lcom/bytedance/android/shopping/api/mall/IECMallHomepageService$c;", "registerRenderListener", "unregisterRenderListener", "Lcom/bytedance/android/shopping/api/mall/IECMallHomepageService$b;", "registerRefreshListener", "unregisterRefreshListener", "", "flag", "notifyDataSetChanged", "", "isFromCache", "", "extraInfo", "notifyRenderFinished", "isManual", "notifyRefreshStart", "isSuccess", "notifyRefreshEnd", "themeId", "recordLoginThemeId", "desc", "recordLoginDesc", "Lcom/google/gson/JsonObject;", "operations", "handleMemoryOperations", "getLoginThemeId", "getLoginDesc", "a", "b", "c", "Section", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IECMallHomepageService {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/IECMallHomepageService$Section;", "", "HEADER", "GUESS_YOU_LIKE", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Section extends Enum<Section> {
        public static final Section GUESS_YOU_LIKE = null;
        public static final Section HEADER = null;
        public static final /* synthetic */ Section[] a = null;

        static {
            Section r1 = new Section("HEADER", 0);
            HEADER = r1;
            Section r2 = new Section("GUESS_YOU_LIKE", 1);
            GUESS_YOU_LIKE = r2;
            a = new Section[]{r1, r2};
        }

        public static Section valueOf(String r1) {
            return (Section) r27.a.a(Section.class, r1);
        }

        public static Section[] values() {
            return (Section[]) a.clone();
        }

        public Section(String r1, int r2) {
            super(r1, r2);
        }
    }

    public interface a {
    }

    public interface b {
    }

    public interface c {
    }

    g getHomepageInstance();

    String getLoginDesc();

    String getLoginThemeId();

    void handleMemoryOperations(JsonObject r1);

    void notifyDataSetChanged(g r1, String r2);

    void notifyRefreshEnd(g r1, boolean r2, boolean r3);

    void notifyRefreshStart(g r1, boolean r2);

    void notifyRenderFinished(g r1, boolean r2, Map<String, ? extends Object> r3);

    void recordLoginDesc(String r1);

    void recordLoginThemeId(String r1);

    void registerDataSetChangeListener(a r1);

    void registerRefreshListener(b r1);

    void registerRenderListener(c r1);

    void releaseInstance(g r1);

    void setupInstance(g r1);

    void unregisterDataSetChangeListener(a r1);

    void unregisterRefreshListener(b r1);

    void unregisterRenderListener(c r1);
}
