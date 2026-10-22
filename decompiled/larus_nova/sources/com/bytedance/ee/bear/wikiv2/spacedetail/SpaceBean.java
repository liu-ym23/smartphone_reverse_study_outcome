package com.bytedance.ee.bear.wikiv2.spacedetail;

import com.bytedance.ee.bear.common.DisplayName;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.util.io.NonProguard;
import java.io.Serializable;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes18.dex */
public class SpaceBean implements NonProguard {
    private int attr;
    private String description;
    private HomePageBean home_page;
    private boolean is_star;
    private List<MembersBean> members;
    private SpaceCoverBean space_cover;
    private String space_icon;
    private String space_id;
    private String space_name;
    private String tenant_id;

    public static class HomePageBean implements Serializable {
        private String obj_token;
        private int obj_type;
        private String wiki_token;

        public HomePageBean() {
        }

        public String getObj_token() {
            return this.obj_token;
        }

        public int getObj_type() {
            return this.obj_type;
        }

        public String getWiki_token() {
            return this.wiki_token;
        }

        public void setObj_token(String r100) {
            this.obj_token = r100;
        }

        public void setObj_type(int r100) {
            this.obj_type = r100;
        }

        public void setWiki_token(String r100) {
            this.wiki_token = r100;
        }
    }

    public static class MembersBean implements Serializable {
        public static int MEMBER_ADMIN = 2;
        public static int MEMBER_MEMBER = 1;
        public static int MEMBER_VISITOR;
        private String description;
        private DisplayName display_name;
        private String icon_url;
        private String member_en_name;
        private String member_id;
        private String member_name;
        private int member_role;
        private int member_type;

        public String getMember_en_name() {
            String r100 = Locale.ENGLISH.getLanguage();
            DisplayName r101 = this.display_name;
            String r102 = this.member_en_name;
            return ou5.a.a(r100, r101, r102, r102);
        }

        public String getMember_name() {
            String r100 = ((i0) org.koin.java.a.a(i0.class)).a();
            DisplayName r101 = this.display_name;
            String r102 = this.member_name;
            return ou5.a.a(r100, r101, r102, r102);
        }

        public MembersBean() {
            this.member_type = -1;
        }

        public String getDescription() {
            return this.description;
        }

        public String getIcon_url() {
            return this.icon_url;
        }

        public String getMember_id() {
            return this.member_id;
        }

        public int getMember_role() {
            return this.member_role;
        }

        public int getMember_type() {
            return this.member_type;
        }

        public void setDescription(String r100) {
            this.description = r100;
        }

        public void setIcon_url(String r100) {
            this.icon_url = r100;
        }

        public void setMember_en_name(String r100) {
            this.member_en_name = r100;
        }

        public void setMember_id(String r100) {
            this.member_id = r100;
        }

        public void setMember_name(String r100) {
            this.member_name = r100;
        }

        public void setMember_role(int r100) {
            this.member_role = r100;
        }

        public void setMember_type(int r100) {
            this.member_type = r100;
        }
    }

    public static class SpaceCoverBean implements Serializable {
        private String color_value;
        private boolean is_graph_dark;
        private String key;
        private String origin;
        private String thumbnail;

        public SpaceCoverBean() {
        }

        public String getColor_value() {
            return this.color_value;
        }

        public String getKey() {
            return this.key;
        }

        public String getOrigin() {
            return this.origin;
        }

        public String getThumbnail() {
            return this.thumbnail;
        }

        public boolean isIs_graph_dark() {
            return this.is_graph_dark;
        }

        public void setColor_value(String r100) {
            this.color_value = r100;
        }

        public void setIs_graph_dark(boolean r100) {
            this.is_graph_dark = r100;
        }

        public void setKey(String r100) {
            this.key = r100;
        }

        public void setOrigin(String r100) {
            this.origin = r100;
        }

        public void setThumbnail(String r100) {
            this.thumbnail = r100;
        }
    }

    public SpaceBean() {
    }

    public int getAttr() {
        return this.attr;
    }

    public String getDescription() {
        return this.description;
    }

    public HomePageBean getHome_page() {
        return this.home_page;
    }

    public List<MembersBean> getMembers() {
        return this.members;
    }

    public SpaceCoverBean getSpace_cover() {
        return this.space_cover;
    }

    public String getSpace_icon() {
        return this.space_icon;
    }

    public String getSpace_id() {
        return this.space_id;
    }

    public String getSpace_name() {
        return this.space_name;
    }

    public String getTenant_id() {
        return this.tenant_id;
    }

    public boolean isIs_star() {
        return this.is_star;
    }

    public void setAttr(int r100) {
        this.attr = r100;
    }

    public void setDescription(String r100) {
        this.description = r100;
    }

    public void setHome_page(HomePageBean r100) {
        this.home_page = r100;
    }

    public void setIs_star(boolean r100) {
        this.is_star = r100;
    }

    public void setMembers(List<MembersBean> r100) {
        this.members = r100;
    }

    public void setSpace_cover(SpaceCoverBean r100) {
        this.space_cover = r100;
    }

    public void setSpace_icon(String r100) {
        this.space_icon = r100;
    }

    public void setSpace_id(String r100) {
        this.space_id = r100;
    }

    public void setSpace_name(String r100) {
        this.space_name = r100;
    }

    public void setTenant_id(String r100) {
        this.tenant_id = r100;
    }
}
