package com.bytedance.ee.bear.drive.biz.cache.manual.model;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class ManualOfflineSyncDeletedTokenData implements Serializable {
    public static final String ACTION_DELETED = "offWatchEntityDeleted";
    private static final long serialVersionUID = 1526287287577557136L;
    private List<Token> tokens;

    public static class Token implements Serializable {
        private String token;
        private int type;

        public Token() {
        }

        public String getToken() {
            return this.token;
        }

        public int getType() {
            return this.type;
        }

        public void setToken(String r1) {
            this.token = r1;
        }

        public void setType(int r1) {
            this.type = r1;
        }
    }

    public ManualOfflineSyncDeletedTokenData() {
    }

    public List<Token> getTokens() {
        return this.tokens;
    }

    public void setTokens(List<Token> r1) {
        this.tokens = r1;
    }
}
