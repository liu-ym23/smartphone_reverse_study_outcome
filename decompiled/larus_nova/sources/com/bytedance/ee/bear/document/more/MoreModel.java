package com.bytedance.ee.bear.document.more;

import android.text.TextUtils;
import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.bear.BlockSimpleInfo;
import com.bytedance.ee.bear.share.export.BitableShareRoleMember;
import com.bytedance.ee.util.io.NonProguard;
import com.larksuite.framework.utils.CollectionUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes16.dex */
public class MoreModel implements NonProguard {
    private String[] badges;
    private Bitable bitable;
    private String[] disables;
    private Enables enables;
    private String[] invisibles;
    private Minutes minutes;
    private Map<String, DisableInfo> newDisables;
    private String[] switchOn;

    public static class AiSummary implements NonProguard {

        @JSONField(name = "tag_info")
        private TagInfo tagInfo;

        public AiSummary() {
        }

        public TagInfo getTagInfo() {
            return this.tagInfo;
        }

        public void setTagInfo(TagInfo r100) {
            this.tagInfo = r100;
        }
    }

    public static class Bitable implements NonProguard {
        private BitableProAccessConfig accessConfig;
        private ArrayList<BlockSimpleInfo> blocks;
        private boolean isPro;
        private ArrayList<BitableShareRoleMember> members;
        private ArrayList<String> roleIds;
        private ArrayList<BlockSimpleInfo> tables;

        public Bitable() {
        }

        public ArrayList<BlockSimpleInfo> getBlocks() {
            ArrayList<BlockSimpleInfo> r100 = this.blocks;
            if (r100 == null) goto L5;
            return r100;
        L5:
            return new ArrayList();
        }

        public ArrayList<BlockSimpleInfo> getTables() {
            ArrayList<BlockSimpleInfo> r100 = this.tables;
            if (r100 == null) goto L5;
            return r100;
        L5:
            return new ArrayList();
        }

        public boolean isProAccessConfigBindRole() {
            BitableProAccessConfig r100 = this.accessConfig;
            if (r100 != null) goto L5;
            return false;
        L5:
            if (r100.getDefaultConfig() == null) goto L16;
            int r101 = this.accessConfig.getDefaultConfig().getAccessStrategy();
            String r102 = this.accessConfig.getDefaultConfig().getRoleId();
            if (r101 == 1) goto L9;
            return false;
        L9:
            if (TextUtils.isEmpty(r102) == false) goto L11;
            return false;
        L11:
            if (CollectionUtils.isEmpty(this.roleIds) == false) goto L13;
            return false;
        L13:
            return this.roleIds.contains(r102);
        L16:
            return false;
        }

        public BitableProAccessConfig getAccessConfig() {
            return this.accessConfig;
        }

        public ArrayList<BitableShareRoleMember> getMembers() {
            return this.members;
        }

        public ArrayList<String> getRoleIds() {
            return this.roleIds;
        }

        public boolean isPro() {
            return this.isPro;
        }

        public void setAccessConfig(BitableProAccessConfig r100) {
            this.accessConfig = r100;
        }

        public void setBlocks(ArrayList<BlockSimpleInfo> r100) {
            this.blocks = r100;
        }

        public void setMembers(ArrayList<BitableShareRoleMember> r100) {
            this.members = r100;
        }

        public void setPro(boolean r100) {
            this.isPro = r100;
        }

        public void setRoleIds(ArrayList<String> r100) {
            this.roleIds = r100;
        }

        public void setTables(ArrayList<BlockSimpleInfo> r100) {
            this.tables = r100;
        }
    }

    public static class BitableProAccessConfig implements NonProguard {
        private BitableProDefaultConfig defaultConfig;

        public BitableProAccessConfig() {
        }

        public BitableProDefaultConfig getDefaultConfig() {
            return this.defaultConfig;
        }

        public void setDefaultConfig(BitableProDefaultConfig r100) {
            this.defaultConfig = r100;
        }
    }

    public static class BitableProDefaultConfig implements NonProguard {
        public static final int ACCESS_STRATEGY_BIND_ROLE = 1;
        private int accessStrategy;
        private String roleId;

        public BitableProDefaultConfig() {
        }

        public int getAccessStrategy() {
            return this.accessStrategy;
        }

        public String getRoleId() {
            return this.roleId;
        }

        public void setAccessStrategy(int r100) {
            this.accessStrategy = r100;
        }

        public void setRoleId(String r100) {
            this.roleId = r100;
        }
    }

    public static class DisableInfo implements NonProguard {
        public String text;

        public DisableInfo() {
            this.text = "";
        }
    }

    public static class Enables implements NonProguard {

        @JSONField(name = "ai_summary")
        private AiSummary aiSummary;

        public Enables() {
        }

        public AiSummary getAiSummary() {
            return this.aiSummary;
        }

        public void setAiSummary(AiSummary r100) {
            this.aiSummary = r100;
        }
    }

    public static class Minutes implements NonProguard {

        @JSONField(name = "isAudioMinutes")
        private boolean audioMinutes;
        private boolean hasAudio;
        private String token;

        public Minutes() {
        }

        public boolean getHasAudio() {
            return this.hasAudio;
        }

        public String getToken() {
            return this.token;
        }

        public boolean isAudioMinutes() {
            return this.audioMinutes;
        }

        public void setAudioMinutes(boolean r100) {
            this.audioMinutes = r100;
        }

        public void setHasAudio(boolean r100) {
            this.hasAudio = r100;
        }

        public void setToken(String r100) {
            this.token = r100;
        }
    }

    public static class TagInfo implements NonProguard {
        private String text;

        public TagInfo() {
        }

        public String getText() {
            return this.text;
        }

        public void setText(String r100) {
            this.text = r100;
        }
    }

    public MoreModel() {
    }

    public Bitable getBitable() {
        Bitable r100 = this.bitable;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return new Bitable();
    }

    public Map<String, String> getDisableReasons() {
        HashMap r100 = new HashMap();
        Map<String, DisableInfo> r101 = this.newDisables;
        if (r101 != null) goto L5;
        return r100;
    L5:
        Iterator<Map.Entry<String, DisableInfo>> r102 = r101.entrySet().iterator();
    L7:
        if (r102.hasNext() == false) goto L9;
        Map.Entry<String, DisableInfo> r103 = r102.next();
        r100.put(r103.getKey(), r103.getValue().text);
        goto L7
    L9:
        return r100;
    }

    public Minutes getMinutes() {
        Minutes r100 = this.minutes;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return new Minutes();
    }

    public String toString() {
        return "MoreData{badges=" + Arrays.toString(this.badges) + ", disable=" + Arrays.toString(this.disables) + '}';
    }

    public String[] getBadges() {
        return this.badges;
    }

    public String[] getDisables() {
        return this.disables;
    }

    public Enables getEnables() {
        return this.enables;
    }

    public String[] getInvisibles() {
        return this.invisibles;
    }

    public String[] getSwitchOn() {
        return this.switchOn;
    }

    public boolean isItemDisabled(String r100) {
        String[] r101 = this.disables;
        if (r101 != null) goto L5;
    L15:
        return false;
    L5:
        if (r101.length <= 0) goto L15;
        if (TextUtils.isEmpty(r100) == true) goto L15;
        String[] r102 = this.disables;
        int r103 = r102.length;
        int r104 = 0;
    L9:
        if (r104 >= r103) goto L15;
        if (r100.equals(r102[r104]) == true) goto L12;
        r104 = r104 + 1;
        goto L9
    L12:
        return true;
    }

    public boolean isItemInvisible(String r100) {
        String[] r101 = this.invisibles;
        if (r101 != null) goto L5;
    L15:
        return false;
    L5:
        if (r101.length <= 0) goto L15;
        if (TextUtils.isEmpty(r100) == true) goto L15;
        String[] r102 = this.invisibles;
        int r103 = r102.length;
        int r104 = 0;
    L9:
        if (r104 >= r103) goto L15;
        if (r100.equals(r102[r104]) == true) goto L12;
        r104 = r104 + 1;
        goto L9
    L12:
        return true;
    }

    public void setBadges(String[] r100) {
        this.badges = r100;
    }

    public void setBitable(Bitable r100) {
        this.bitable = r100;
    }

    public void setDisables(String[] r100) {
        this.disables = r100;
    }

    public void setEnables(Enables r100) {
        this.enables = r100;
    }

    public void setInvisibles(String[] r100) {
        this.invisibles = r100;
    }

    public void setMinutes(Minutes r100) {
        this.minutes = r100;
    }

    public void setNewDisables(Map<String, DisableInfo> r100) {
        this.newDisables = r100;
    }

    public void setSwitchOn(String[] r100) {
        this.switchOn = r100;
    }

    public boolean shouldShowBadges(String r100) {
        String[] r101 = this.badges;
        if (r101 != null) goto L5;
    L15:
        return false;
    L5:
        if (r101.length <= 0) goto L15;
        if (TextUtils.isEmpty(r100) == true) goto L15;
        String[] r102 = this.badges;
        int r103 = r102.length;
        int r104 = 0;
    L9:
        if (r104 >= r103) goto L15;
        if (r100.equals(r102[r104]) == true) goto L12;
        r104 = r104 + 1;
        goto L9
    L12:
        return true;
    }
}
