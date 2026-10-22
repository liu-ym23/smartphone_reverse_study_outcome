package com.bytedance.apm.agent.logging;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class AndroidAgentLog implements AgentLog {
    private static final String TAG = "[tt_apm]";
    private int level;

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void audit(String r1) {
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void debug(String r1) {
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void error(String r1) {
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void error(String r1, Throwable r2) {
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void info(String r1) {
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void verbose(String r1) {
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void warning(String r1) {
    }

    public AndroidAgentLog() {
        this.level = 3;
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public int getLevel() {
        return this.level;
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void setLevel(int r2) {
        if (r2 > 6) goto L9;
        if (r2 < 1) goto L9;
        this.level = r2;
        return;
    L9:
        throw new IllegalArgumentException("Log level is not between ERROR and AUDIT");
    }
}
