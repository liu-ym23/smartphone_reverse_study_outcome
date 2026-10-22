package com.bytedance.apm.agent.logging;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class ConsoleAgentLog implements AgentLog {
    private int mLevel;

    public ConsoleAgentLog() {
        this.mLevel = 3;
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public int getLevel() {
        return this.mLevel;
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void audit(String r3) {
        if (this.mLevel != 6) goto L6;
        print("AUDIT", r3);
        return;
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void debug(String r3) {
        if (this.mLevel < 5) goto L6;
        print("DEBUG", r3);
        return;
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void error(String r3) {
        if (this.mLevel < 1) goto L6;
        print("ERROR", r3);
        return;
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void info(String r3) {
        if (this.mLevel < 3) goto L6;
        print("INFO", r3);
        return;
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void setLevel(int r1) {
        this.mLevel = r1;
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void verbose(String r3) {
        if (this.mLevel < 4) goto L6;
        print("VERBOSE", r3);
        return;
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void warning(String r3) {
        if (this.mLevel < 2) goto L6;
        print("WARN", r3);
        return;
    }

    private static void print(String r3, String r4) {
        System.out.println("[" + r3 + "] " + r4);
    }

    @Override // com.bytedance.apm.agent.logging.AgentLog
    public void error(String r3, Throwable r4) {
        if (this.mLevel < 1) goto L6;
        print("ERROR", r3 + " " + r4.getMessage());
        return;
    }
}
