package com.ss.android.lark.search.dto.info;

import com.bytedance.lark.pb.search.v1.ExtraHitField;
import com.ss.android.lark.search.dto.OpenAppState;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public class SearchOpenAppInfo extends SearchBaseInfo {
    private static final long serialVersionUID = 8909572639273974577L;
    private List<SearchOpenAppAbility> abilities;
    private ArrayList<AppShortCut> appShortCuts;
    private OpenAppState appState;
    private String appStoreUrl;
    private List<ExtraHitField> extraHitFields;
    private boolean isAvailable;

    public static class AppShortCut implements Serializable {
        private String appLink;
        private String name;

        public String getAppLink() {
            return this.appLink;
        }

        public String getName() {
            return this.name;
        }

        public void setAppLink(String r100) {
            this.appLink = r100;
        }

        public void setName(String r100) {
            this.name = r100;
        }

        public AppShortCut(String r100, String r101) {
            this.name = r100;
            this.appLink = r101;
        }
    }

    public static class SearchOpenAppAbility implements Serializable {
        private static final long serialVersionUID = 7989518027963432944L;
        private String requiredInfo;
        private int type;

        public String getRequiredInfo() {
            return this.requiredInfo;
        }

        public int getType() {
            return this.type;
        }

        public static /* synthetic */ int access$000(SearchOpenAppAbility r100) {
            return r100.type;
        }

        public SearchOpenAppAbility(int r100, String r101) {
            this.type = r100;
            this.requiredInfo = r101;
        }
    }

    @Override // com.ss.android.lark.search.dto.info.SearchBaseInfo
    public String getResultTypeForReport() {
        if (this.isAvailable == true) goto L5;
        return "apps";
    L5:
        Iterator<SearchOpenAppAbility> r100 = this.abilities.iterator();
    L7:
        if (r100.hasNext() == false) goto L13;
        SearchOpenAppAbility r101 = r100.next();
        if (SearchOpenAppAbility.access$000(r101) == 2) goto L12;
        if (SearchOpenAppAbility.access$000(r101) != 3) goto L7;
    L12:
        return "apps";
    L13:
        return "app_bot";
    }

    @Override // com.ss.android.lark.search.dto.info.SearchBaseInfo
    public String getTagForReport() {
        StringBuilder r100 = new StringBuilder(super.getTagForReport());
        if (this.isAvailable == true) goto L6;
        r100.append("uninstalled_app,");
    L6:
        return r100.toString();
    }

    public SearchOpenAppInfo() {
        this.abilities = new ArrayList();
        this.appState = OpenAppState.USABLE;
        this.isAvailable = true;
        this.extraHitFields = new ArrayList();
        this.type = 12;
    }

    public List<SearchOpenAppAbility> getAbilities() {
        return this.abilities;
    }

    public ArrayList<AppShortCut> getAppShortCuts() {
        return this.appShortCuts;
    }

    public OpenAppState getAppState() {
        return this.appState;
    }

    public String getAppStoreUrl() {
        return this.appStoreUrl;
    }

    public List<ExtraHitField> getExtraHitFields() {
        return this.extraHitFields;
    }

    public boolean isAvailable() {
        return this.isAvailable;
    }

    public void available(boolean r100) {
        this.isAvailable = r100;
    }

    public void setAbilities(List<SearchOpenAppAbility> r100) {
        this.abilities = r100;
    }

    public void setAppShortCuts(ArrayList<AppShortCut> r100) {
        this.appShortCuts = r100;
    }

    public void setAppState(OpenAppState r100) {
        this.appState = r100;
    }

    public void setAppStoreUrl(String r100) {
        this.appStoreUrl = r100;
    }

    public void setExtraHitFields(List<ExtraHitField> r100) {
        this.extraHitFields = r100;
    }
}
